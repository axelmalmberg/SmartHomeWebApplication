/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Classes.Device;
import Classes.Room;
import Classes.Sensor;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author optimus prime
 */
@WebServlet(urlPatterns = {"/createNewHomeController"})
public class createNewHomeController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //HERE THE FUNCTIONALITY FOR CREATING A SMART HOME IS LOCATED
        //IF YOU WANT TO ADD A NEW LAMP ETC, IT IS DONE !
        //IT WILL BE WORKING WITH THE createNewHome.jsp
        //DO CODE FOR SORTING WHICH OF THE INFORMATION WILL BE ADDED 
        //LIKE IS THE ADD DEVICE BUTTON CLICKED? THEN DO ADD DEVICE CODE
        //Code here
        response.setContentType("text/html;charset=UTF-8");
        String addSensor = request.getParameter("addSemsor");

    }
    public HashMap getHashmapfromJsonString(String JsonString) {
        //String output = JsonString.substring(1, JsonString.length() - 1);
        HashMap<String, String> tmpMap = new Gson().fromJson(JsonString, new TypeToken<HashMap<String, String>>() {
        }.getType());
        return tmpMap;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        requestToApi rta = new requestToApi();
        DataStorage ds = new DataStorage();
        if (request.getParameter("button1") != null) {

            System.out.println("added HomeServer");
            String serverName = request.getParameter("serverName");
            System.out.println("servername: " + serverName + " userId: " + ds.getUserId());
            rta.addHomeServer(serverName, ds.getUserId());
        } else if (request.getParameter("button2") != null) {
            System.out.println("added Room");
            String roomName = request.getParameter("roomName");
            HomeServer hs = new HomeServer();
            hs = (HomeServer) ds.servers.get(0);
            String serverId = hs.getHomeServerId();

            System.out.println("RoomName: " + roomName + " serverid: " + serverId);
            rta.addRoom(roomName, serverId);

        } else if (request.getParameter("button3") != null) {
            System.out.println("added Device");

            String deviceName = request.getParameter("deviceName");
            String roomId = request.getParameter("roomId");
            rta.addDevice(deviceName, roomId);
        } else if (request.getParameter("button4") != null) {
            System.out.println("added Sensor");
            String sensorName = request.getParameter("sensorName");
            String sensorType = request.getParameter("sensorType");
            String deviceId = request.getParameter("deviceId");
            rta.addSensor(sensorName, sensorType, deviceId);
        }
        ArrayList<Room> rooms = new ArrayList<Room>();
        ArrayList<Object> devices = new ArrayList<>();
        ArrayList<Object> Sensors = new ArrayList<>();
        Recieve r = new Recieve();
        String userId = ds.getUserId();
        String homeServerIdJsonString = r.getHomeServer(userId);

        try {
            JSONArray jHomeServerArr = new JSONArray(homeServerIdJsonString);
            if (jHomeServerArr.isNull(0) == false) {
                JSONObject jHomeServerObject = jHomeServerArr.getJSONObject(0);
                String homeServerJsonObjectString = jHomeServerObject.toString();
                HashMap<String, String> homeServerIdMap = getHashmapfromJsonString(homeServerJsonObjectString);

                //VARIABLES TO BE REMEMBERED
                String homeServerId = homeServerIdMap.get("Homeserver_id");
                String homeServerName = homeServerIdMap.get("Server_name");

                HomeServer hs = new HomeServer();
                hs.setUserId(userId);
                hs.setHomeServerId(homeServerId);
                hs.setHomeServerName(homeServerName);
                //ds.servers.add(hs);
                System.out.println(homeServerId + " " + homeServerName);

                //VARIABLES TO BE REMEMBERED
                String roomIdJsonString = r.getRooms(homeServerId);
                JSONArray jRoomArr = new JSONArray(roomIdJsonString);
                for (int i = 0; i < jRoomArr.length(); i++) {

                    JSONObject jRoomObject = jRoomArr.getJSONObject(i);
                    String roomJsonObjectString = jRoomObject.toString();
                    HashMap<String, String> roomIdMap = getHashmapfromJsonString(roomJsonObjectString);

                    //VARIABLES TO BE REMEMBERED
                    String roomId = roomIdMap.get("Room_id");
                    String roomName = roomIdMap.get("Room_name");

                    Room room = new Room();
                    room.setRoomId(roomId);
                    room.setRoomName(roomName);
                    //ds.rooms.add(room);
                    System.out.println("Adding room to list: " + roomName);
                    rooms.add(room);

                    System.out.println(roomId + " " + roomName + " room: " + i);
                    //VARIABLES TO BE REMEMBERED

                    String deviceIdJsonString = r.getDevices(roomId);
                    JSONArray jDeviceArr = new JSONArray(deviceIdJsonString);

                    for (int j = 0; j < jDeviceArr.length(); j++) {
                        JSONObject jDeviceObject = jDeviceArr.getJSONObject(j);
                        String deviceJsonObjectString = jDeviceObject.toString();
                        HashMap<String, String> deviceIdMap = getHashmapfromJsonString(deviceJsonObjectString);

                        //VARIABLES TO BE REMEMBERED
                        String deviceId = deviceIdMap.get("Device_id");
                        String deviceName = deviceIdMap.get("Device_name");

                        Device device = new Device();
                        device.setDeviceId(deviceId);
                        device.setDeviceName(deviceName);
                        device.setRoomId(roomId);
                        //ds.devices.add(device);
                        devices.add(device);

                        System.out.println(deviceId + " " + deviceName + " device: " + j);
                        //VARIABLES TO BE REMEMBERED

                        String sensorIdJsonString = r.getSensors(deviceId);
                        JSONArray jSensorArr = new JSONArray(sensorIdJsonString);

                        for (int k = 0; k < jSensorArr.length(); k++) {
                            JSONObject jSensorObject = jSensorArr.getJSONObject(k);
                            String sensorJsonObjectString = jSensorObject.toString();
                            HashMap<String, String> sensorIdMap = getHashmapfromJsonString(sensorJsonObjectString);

                            //VARIABLES TO BE REMEMBERED
                            String sensorId = sensorIdMap.get("Sensor_id");
                            String sensorType = sensorIdMap.get("Sensor_type");
                            String sensorName = sensorIdMap.get("Sensor_name");

                            Sensor sensor = new Sensor();
                            sensor.setDeviceId(deviceId);
                            sensor.setSensorId(sensorId);
                            sensor.setSensorName(sensorName);
                            sensor.setSensorType(sensorType);
                            //ds.sensors.add(sensor);
                            Sensors.add(sensor);

                            System.out.println(sensorId + " " + sensorType + " " + sensorName + " sensor: " + k);
                            //VARIABLES TO BE REMEMBERED        

                            //If the password or username is wrong it will be sent to a page informing the user that he/she has done wrong and o try again
                        }
                    }
                }
            }
            //request.setAttribute("idSend", userId);
            request.setAttribute("roomList", rooms);
            request.setAttribute("deviceList", devices);

            request.getRequestDispatcher("createNewHome.jsp").forward(request, response);
        } catch (JSONException ex) {
            Logger.getLogger(createNewHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

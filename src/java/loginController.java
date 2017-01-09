/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Classes.Sensor;
import Classes.Device;
import Classes.Room;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author optimus prime
 */
@WebServlet(urlPatterns = {"/loginController"})
public class loginController extends HttpServlet {

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

        //IT WILL WORK WITH login.jsp
        //IF YES THE USER WILL BE SENT TO home.jsp AND THE HOMECONTROLLER WILL BE IN CHARGE
        response.setContentType("text/html;charset=UTF-8");
        String function = request.getParameter("function");

        ArrayList<Room> rooms = new ArrayList<Room>();
        ArrayList<Object> devices = new ArrayList<>();
        ArrayList<Object> Sensors = new ArrayList<>();
        //If statment is checking of the values in the button is changed(it does if the button is clicked)
        if (function.equalsIgnoreCase("login-info")) {

            //Here the information for the login.jsp Textfields is requested
            String username = request.getParameter("username");
            String pass = request.getParameter("password");

            //Here we send the username and password to the API
            //The output variable contains the respons from the API
            requestToApi rta = new requestToApi();
            String output = rta.logIn(username, pass);
            System.out.println(output);

            //if the username and password is correct it will change to the Registrationpage (JSP) where you can continue with the reg
            //IT will also send the ID of the user to the homepage so that the correct information is gathered
            if (output.contains("id")) {
                String[] userIdArray = output.split(":");

                //VARIABLES TO BE REMEMBERED
                String userId = String.valueOf(userIdArray[1].charAt(0));
                DataStorage datastore = new DataStorage();
                datastore.userId = userId;
                //VARIABLES TO BE REMEMBERED

                //TALK TO THE Recieve CLASS BECAUSE WE ARE USING GET COMMANDS HERE
                //AFTER WE HAVE GOTTEN THE OUTPUT WE MAKE IT INTO A HASHMAP
                //BEFORE GETTING THE VALUE WE WANT TO MAKE THE NEXT GET REQUEST
                Recieve r = new Recieve();
                String homeServerIdJsonString = r.getHomeServer(userId);

                try {
                    JSONArray jHomeServerArr = new JSONArray(homeServerIdJsonString);
                    if (jHomeServerArr.isNull(0) == false) {
                        JSONObject jHomeServerObject = jHomeServerArr.getJSONObject(0);
                        String homeServerJsonObjectString = jHomeServerObject.toString();
                        HashMap<String, String> homeServerIdMap = getHashmapfromJsonString(homeServerJsonObjectString);

                        DataStorage ds = new DataStorage();

                        //VARIABLES TO BE REMEMBERED
                        String homeServerId = homeServerIdMap.get("Homeserver_id");
                        String homeServerName = homeServerIdMap.get("Server_name");

                        HomeServer hs = new HomeServer();
                        hs.setUserId(userId);
                        hs.setHomeServerId(homeServerId);
                        hs.setHomeServerName(homeServerName);
                        ds.servers.add(hs);
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
                            ds.rooms.add(room);
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
                                ds.devices.add(device);
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
                                    ds.sensors.add(sensor);
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

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                // THIS IS UNDER CONSTRUCTION WE NEED TO GET ALL THE INFO AND SEND TO THE NEXT JSP/SERVLET THING
                //System.out.println(aux);

            } else {
                request.setAttribute("username", username);
                request.setAttribute("pass", pass);
                request.setAttribute("function", function);
                request.getRequestDispatcher("BadInfo.jsp").forward(request, response);
            }

        }

    }

    //THIS METHOD IS MADE SO THAT YOU CAN MAKE THE STRING INTO A MAP
    //IT IS GOOD TO HAVE A MAP SO THAT YOU CAN GET THE VALUE FOR A SPECIFIC KEY
    //EXAMPLE WOULD BE THAT YOU ONLY WAN THE ID
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
        processRequest(request, response);
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

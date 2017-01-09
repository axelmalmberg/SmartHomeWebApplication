/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Classes.Room;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            System.out.println("servername: " + serverName  + " userId: " + ds.getUserId());
            rta.addHomeServer(serverName, ds.getUserId());
        } else if (request.getParameter("button2") != null) {
            System.out.println("added Room");
            String roomName = request.getParameter("roomName");
            HomeServer hs = new HomeServer();
            hs = (HomeServer) ds.servers.get(0);
            String serverId = hs.getHomeServerId();
            
            System.out.println("RoomName: " + roomName  + " serverid: " + serverId);
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

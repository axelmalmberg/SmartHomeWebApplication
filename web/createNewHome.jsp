<%-- 
    Document   : createNewHome
    Created on : 2016-nov-29, 16:00:58
    Author     : optimus prime

HERE HTML CODE WILL BE USED TO CREATE A INTERFACE FOR THE USER CREATE A NEW SMARTHOME!!!!!!
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Classes.Room"%>
<%@page import="Classes.Device"%>
<%@page import="Classes.Sensor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body> 

        <form action="createNewHomeController" method="post">
            Add HomeServer
            <hr>
            Server Name:
            <input type="text" name="serverName"><br><br>
            <input type="submit" name="button1" value="button 1"><br><br>
        </form>

        <form action="createNewHomeController" method="post">
            Add Room:
            <hr>
            Room Name:
            <input type="text" name="roomName"><br><br>
            <input type="submit" name="button2"value="button 2"><br><br>
        </form>

        <form action="createNewHomeController" method="post">
            Add Device:
            <hr>
            <%
                // retrieve your list from the request, with casting 
                ArrayList<Room> list = (ArrayList<Room>) request.getAttribute("roomList");
                // print the information about every category of the list
                for (Room rooms : list) {
                    out.println(rooms.getRoomName());
                    out.println(" has room ID:  ");
                    out.println(rooms.getRoomId());

            %><br><br><%                        }
            %> 
            Device Name:
            <input type="text" name="deviceName"><br><br>
            Room Id: 
            <input type="text" name="roomId">
            <br><br>
            <input type="submit" name="button3"value="button 3"><br><br>
        </form>

        <form action="createNewHomeController" method="post">
            Add Sensor:
            <hr>
            <%
                // retrieve your list from the request, with casting 
                ArrayList<Device> list2 = (ArrayList<Device>) request.getAttribute("deviceList");
                // print the information about every category of the list
                for (Device devices: list2) {
                    out.println(devices.getDeviceName());
                    out.println(" has device ID:  ");
                    out.println(devices.getDeviceId());

            %><br><br><%                        }
            %> 
            Sensor Name:
            <input type="text" name="sensorName"><br><br>
            Sensor Type:
            <input type="text" name="sensorType"><br><br>
            Device ID:
            <input type="text" name="deviceId"><br><br>
            <input type="submit" name="button4"value="button 4"><br><br>
        </form>

    </body>
</html>

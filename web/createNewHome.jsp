<%-- 
    Document   : createNewHome
    Created on : 2016-nov-29, 16:00:58
    Author     : optimus prime

HERE HTML CODE WILL BE USED TO CREATE A INTERFACE FOR THE USER CREATE A NEW SMARTHOME!!!!!!
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Classes.Room"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body> 

        <form action="AddHomeServer">
            Add HomeServer
            <hr>
            Server Name:
            <input type="text" name="serverName"><br><br>
            <input type="submit" name="Submit"><br><br>
        </form>

        <form action="AddRoom">
            Add Room:
            <hr>
            Room Name:
            <input type="text" name="roomName"><br><br>
            <input type="submit" name="Submit"><br><br>
        </form>

        <form action="AddDevice">
            Add Device:
            <hr>
            Device Name:
            <input type="text" name="deviceName"><br><br>
            Room Id:
            <%
                // retrieve your list from the request, with casting 
                ArrayList<Room> list = (ArrayList<Room>) request.getAttribute("roomList");

                // print the information about every category of the list
                for (Room rooms : list) {
                    out.println(rooms.getRoomName());
                    out.println("  ");
                    out.println(rooms.getRoomId());
                    %><br><br><%
                }
            %> 

            <select name="roomId">

                <option value="1">1</option>

            </select><br><br>
            <input type="submit" name="Submit"><br><br>
        </form>

        <form action="AddSensor">
            Add Sensor:
            <hr>
            Sensor Name:
            <input type="text" name="sensorName"><br><br>
            Sensor Type:
            <input type="text" name="sensorType"><br><br>
            Device ID:
            <select name="deviceID">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
            </select><br><br>
            <input type="submit" name="Submit"><br><br>
        </form>

    </body>
</html>

<%-- 
    Document   : createNewHome
    Created on : 2016-nov-29, 16:00:58
    Author     : optimus prime

HERE HTML CODE WILL BE USED TO CREATE A INTERFACE FOR THE USER CREATE A NEW SMARTHOME!!!!!!
--%>

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
            User ID:
            <input type="text" name="userID"><br><br>
            <input type="submit" name="Submit"><br><br>
        </form>

        <form action="AddRoom">
            Add Room:
            <hr>
            Room Name:
            <input type="text" name="roomName"><br><br>
            Server ID:
            <input type="text" name="serverID"><br><br>
            <input type="submit" name="Submit"><br><br>
        </form>

        <form action="AddDevice">
            Add Device:
            <hr>
            Device Name:
            <input type="text" name="deviceName"><br><br>
            Room Id:
            <input type="text" name="roomID"><br><br>
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
            <input type="text" name="deviceID"><br><br>
            <input type="submit" name="Submit"><br><br>
        </form>

    </body>
</html>

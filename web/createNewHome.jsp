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
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>
    <head>
        <!-- Latest compiled and minified CSS -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"><!-- Optional theme -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" rel="stylesheet"><!-- Latest compiled and minified JavaScript -->

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <link href="style.css" rel="stylesheet">

        <title>Smart Home - HKR</title>
        <meta charset="UTF-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
    </head>

    <body style="background: url(bg-home.jpg) no-repeat center center fixed;">
        <div class="site-wrapper">
            <div class="site-wrapper-inner">
                <div class="cover-container">
                    <div class="masthead clearfix">
                        <div class="inner">
                            <h3 class="masthead-brand">Smart Home - HKR</h3>


                            <ul class="nav masthead-nav">

                                <form method="link" action="logoutprocess.jsp">
                                    <input type="submit" class="btn btn-s btn-success" value="Logout" align="right">
                                </form>
                            </ul>
                        </div>
                    </div>


                    <div class="inner cover">
                        <h1 class="cover-heading">Create your smart home</h1>
                        <br>


                        <p class="lead">The steps for you to create your first smart home is following. You need to Add a home and then add rooms inside that home, add your smart devices and sensors. Simples as that!<br>
                            <small><br>
                                Start here</small></p>
                        <br>


                        <p class="lead"><a class="btn btn-lg btn-success" href="#" data-toggle="modal" data-target="#addHomeServer">Add home</a>
                            <a class="btn btn-lg btn-success" href="#" data-toggle="modal" data-target="#addRoom">Add room</a>
                            <a class="btn btn-lg btn-success" href="#" data-toggle="modal" data-target="#addDevice">Add device</a>
                            <a class="btn btn-lg btn-success" href="#" data-toggle="modal" data-target="#addSensor">Add sensors</a>
                        </p>
                    </div>

                    <div id="addHomeServer" class="modal fade" role="document">
                        <div class="modal-dialog">
                            <!-- Add HomeServer-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title" style="color: black;">Add Home Server</h4>
                                </div>
                                <div class="modal-body" style="color: black;">
                                    <form action="createNewHomeController" method="post">
                                        Server Name:
                                        <input type="text" name="serverName"><br><br>
                                        <input type="submit" name="button1" class="btn btn-s btn-success" value="Add home"><br><br>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div id="addRoom" class="modal fade" role="document">
                        <div class="modal-dialog">
                            <!-- Add Room-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title" style="color: black;">Add Room</h4>
                                </div>
                                <div class="modal-body" style="color: black;">
                                    <form action="createNewHomeController" method="post">
                                        Room Name:
                                        <input type="text" name="roomName"><br><br>
                                        <input type="submit" name="button2" class="btn btn-s btn-success" value="Add room"><br><br>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div id="addDevice" class="modal fade" role="document">
                        <div class="modal-dialog">
                            <!-- Add Device-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title" style="color: black;">Add Device</h4>
                                </div>
                                <div class="modal-body" style="color: black;">
                                    <form action="createNewHomeController" method="post">
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
                                        <input type="submit" name="button3" class="btn btn-s btn-success" value="Add device"><br><br>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div id="addSensor" class="modal fade" role="document">
                        <div class="modal-dialog">
                            <!-- Add Sensor-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title" style="color: black;">Add Sensor</h4>
                                </div>
                                <div class="modal-body" style="color: black;">
                                    <form action="createNewHomeController" method="post">
                                        <%
                                            // retrieve your list from the request, with casting 
                                            ArrayList<Device> list2 = (ArrayList<Device>) request.getAttribute("deviceList");
                                            // print the information about every category of the list
                                            for (Device devices : list2) {
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
                                        <input type="submit" name="button4" class="btn btn-s btn-success" value="Add sensor"><br><br>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                    </div>
        </div>
                    <div class="mastfoot">
                        <div class="inner">
                            <p>Copyright © 2017 TBSYK - <a href="http://hkr.se">Kristianstad University</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
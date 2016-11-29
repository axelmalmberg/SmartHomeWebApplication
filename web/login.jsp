<%-- 
    Document   : login
    Created on : 2016-nov-29, 15:54:05
    Author     : optimus prime

HERE IS HTML CODE FOR THE USER TO ENTER LOGIN INFORMATION AND TO SUBMIT!!!!!!

NEEDS TO BE ADDED AN OPTION FOR SIGNING UP!!!
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <hr>
        <h2>User credentials</h2>
        <form action="loginController">
            Username:
            <input type="text" name="username"><br><br>
            Password:
            <input type="password" name="password">
            <input type="hidden" name="function" value="login-info">
            <br><br>
            <input type="submit" name="Submit">
        </form>
    </body>
</html>

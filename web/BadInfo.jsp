<%-- 
    Document   : BadInfo
    Created on : 2016-nov-24, 13:29:20
    Author     : bumblebee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bad Info</title>
    </head>
    <body>
        <form action="addNewUserController" method="post">
        <h1>You entered something wrong, go back and try again</h1>
        <%
            out.println("Username: " + request.getAttribute("username"));
        %>
        <br>
        <%
            out.println("Password: " + request.getAttribute("pass"));
        %>
        <br><br>
        <h1>Not a user? create an account today!</h1>
        <br><br>
        Username:
        <input type="text" name="username"><br><br>
        Password:
        <input type="password" name="password"><br><br>
        Password:
        <input type="password" name="password2"><br><br>
        Email:
        <input type="text" name="email"><br><br>
        <input type="submit" name="button1" value="Button 1">
        </form>
    </body>
</html>

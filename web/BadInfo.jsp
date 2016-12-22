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
        <h1>You entered something wrong, go back and try again</h1>
        <%
            out.println("Username: " + request.getAttribute("username"));
        %>
        <br>
        <%
            out.println("Password: " + request.getAttribute("pass"));
        %>
    </body>
</html>

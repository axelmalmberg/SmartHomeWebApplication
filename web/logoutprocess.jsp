<%-- 
    Document   : logoutprocess
    Created on : 10-Jan-2017, 21:36:50
    Author     : AbuIlyas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Smart Home - HKR</title>
    </head>
    <body>
        
        <%
            session.invalidate();
        %>
        <h2>You are sucessfully logged out...</h2>
        <a href="index.html">Go back to home page</a>
        
    </body>
</html>

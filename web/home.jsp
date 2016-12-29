<%-- 
    Document   : home
    Created on : 2016-nov-29, 16:00:22
    Author     : optimus prime

HERE HTML CODE WILL BE USED TO CREATE A INTERFACE FOR THE USER TO BE ABLE TO CONTROLL HIS/HER HOME!!!
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <script src="https://cdn.pubnub.com/sdk/javascript/pubnub.4.3.3.js"></script>
        <script src="ReceivePubNub.js" type="text/javascript"></script> 
        
        <title>Home</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <hr>
        
        <script type="text/javascript">
            subscribe();
        </script>

        <form action="homeController">
        <input type="Submit" name="function" value="submit">
        <% 
        out.print("YOUR ID IS:" + request.getAttribute("idSend"));
        %>
        </form>
    </body>
</html>

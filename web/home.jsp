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
        <script src="OnClickJs.js" type="text/javascript"></script> 
        
        <title>Home</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <hr>
        <p>Change device statuses</p>
        
        <%-- 
            Something like this for each button probably gonna do js function
            for each button thats gonna be in the home.jsp
        
            PseudoCode
            Script 
            Var buttonLightName = getSensorLight 
            button type"lightButton" onClick"onClickLight();">buttonLightName
            End Script
        
            ToDo: Add buttonClick functionality in OnClickLight
            In OnClickLight send change of sensorStatus
        
        --%>
        
        <button type="lightButton" onclick="onClickLight();">Light ON</button>
        <br><br>
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

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

        <script type="text/javascript">
            subscribe();

        </script>

        <h1>Hello World!</h1>

        <div id='result'></div>

        <form action="homeController">
            <input type="Submit" name="function" value="submit">
            <%
                out.print("YOUR ID IS:" + request.getAttribute("idSend"));
            %>
        </form>

        <hr>
        <p>Change device statuses</p>
        
        <p id="atticTempLabel">AtticTemp</p><br<br>
        <p id="roomTempLabel">Roomtemp</p><br<br>
        <p id="outTempLabel">OutTemp</p><br<br>
        <p id="powerConsumptionLabel">PowerConsumption</p><br<br>
        <p id="burglarAlarmLabel">BurglarAlarm</p><br<br>
        <p id="stoveStatusLabel">StoveStatus</p><br<br>
        <p id="windowStatusLabel">WindowStatus</p><br<br>
        <p id="atticFanLabel">AtticFan</p><br<br>
        <p id="waterLeakageLabel">WaterLeakage</p><br<br>
        <p id="fireAlarmLabel">FireAlarm</p><br<br>
        
        <button type="Button" id="indoorlightButton" onclick="onClickLight(this.id)"></button>
        <button type="Button" id="outdoorlightButton" onclick="onClickLight(this.id)"></button>
        
        <script>
            console.log("Listener 1");
            var resultTemp = (document.getElementById("result"));
            console.log("Listener 2");
            resultTemp.addEventListener("change", function() {
                var atticTemp = (resultTemp.innerHTML = localStorage.getItem("atticTemp"));
                var roomTemp = (resultTemp.innerHTML = localStorage.getItem("roomTemp"));
                var outTemp = (resultTemp.innerHTML = localStorage.getItem("outTemp"));
                var powerConsumption = (resultTemp.innerHTML = localStorage.getItem("powerConsumption"));
                var burglarAlarm = (resultTemp.innerHTML = localStorage.getItem("burglarAlarm"));
                var stoveStatus = (resultTemp.innerHTML = localStorage.getItem("stoveStatus"));
                var windowStatus = (resultTemp.innerHTML = localStorage.getItem("windowStatus"));
                var atticFan = (resultTemp.innerHTML = localStorage.getItem("atticFan"));
                var indoorLight  = (resultTemp.innerHTML = localStorage.getItem("indoorLight"));
                var outdoorLight = (resultTemp.innerHTML = localStorage.getItem("outdoorLight"));
                var waterLeakage = (resultTemp.innerHTML = localStorage.getItem("waterLeakage"));
                var fireAlarm = (resultTemp.innerHTML = localStorage.getItem("fireAlarm"));
                console.log("Listener 3");
                console.log(indoorLight, outdoorLight, fireAlarm, waterLeakage);
                console.log("Listener 4");
                document.getElementById("indoorLightButton").value=indoorLight;
                document.getElementById("outdoorLightButton").value=outdoorLight;
                console.log("Listener 5");
            });
            
            
        </script>
        
        <br><br>
        <hr>
    </body>
</html>

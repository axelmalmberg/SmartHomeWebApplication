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
        <button type="Button" id="lightButton" onclick="onClickLight(this.id)"></button>
        <script>
            console.log("Listener 1");
            var resultTemp = (document.getElementById("result"));
            console.log("Listener 2");
            resultTemp.addEventListener("change", function() {
                var resultLight = (resultTemp.innerHTML = localStorage.getItem("light"));
                console.log("Listener 3");
                console.log(resultLight);
                console.log("Listener 4");
                document.getElementById("lightButton").value=resultLight;
                console.log("Listener 5");
            });
            
            
        </script>
        
        <br><br>
        <hr>
    </body>
</html>

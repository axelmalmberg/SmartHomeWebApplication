<%-- 
    Document   : logoutprocess
    Created on : 10-Jan-2017, 21:36:50
    Author     : AbIlyas- vheyam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Smart Home - HKR</title>
              <script type="text/javascript">
         <!--
            function Redirect() {
               window.location="index.html";
            }
            
            document.write("You are sucessfully logged out... You will be redirected to home page in 1 sec.");
            setTimeout('Redirect()', 1000);
         //-->
      </script>
    </head>
    <body>
        
        <%
            session.invalidate();
        %>
      
    </body>
</html>

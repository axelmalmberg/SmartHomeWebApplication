<%-- 
    Document   : addNewUser
    Created on : 2016-nov-29, 16:00:43
    Author     : optimus prime

HERE HTML CODE WILL BE USED TO CREATE A INTERFACE FOR THE USER TO SIGN UPP!!!!!!

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Smart Home - HKR</title>
    </head>
    <body>
        <h1>Register</h1>
        <hr>
        <h2>New user</h2>
        <h3><%
            
            try{
                String sum = request.getAttribute("sum").toString();
                if(sum.length() > 2){
                    out.println(sum);
                }
            }catch(NullPointerException ex){
                out.println("Type in your information: ");
            }
            %>
        </h3>
        <form action="addNewUserController">
            Username:
            <input type="text" name="username"><br><br>
            Password:
            <input type="password" name="password"><br><br>
            Password:
            <input type="password2" name="password2">
            <input type="hidden" name="function" value="add-info">
            <br><br>
            <input type="submit" name="Submit">
        </form>
    </body>
</html>

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author optimus prime
 */
@WebServlet(urlPatterns = {"/loginController"})
public class loginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        //IT WILL WORK WITH login.jsp
        //IF YES THE USER WILL BE SENT TO home.jsp AND THE HOMECONTROLLER WILL BE IN CHARGE
        response.setContentType("text/html;charset=UTF-8");
        String function = request.getParameter("function");

        //If statment is checking of the values in the button is changed(it does if the button is clicked)
        if (function.equalsIgnoreCase("login-info")) {

            //Here the information for the login.jsp Textfields is requested
            String username = request.getParameter("username");
            String pass = request.getParameter("password");

            //Here we send the username and password to the API
            //The output variable contains the respons from the API
            requestToApi rta = new requestToApi();
            String output = rta.logIn(username, pass);
            System.out.println(output);
            
            
            

            //if the username and password is correct it will change to the Registrationpage (JSP) where you can continue with the reg
            //IT will also send the ID of the user to the homepage so that the correct information is gathered
            if (output.contains("id")) {             
                String[] tmpAr = output.split(":");
                String id = String.valueOf(tmpAr[1].charAt(0));
                request.setAttribute("idSend", id);
                request.getRequestDispatcher("home.jsp").forward(request, response);

                //If the password or username is wrong it will be sent to a page informing the user that he/she has done wrong and o try again
            } else {
                request.setAttribute("username", username);
                request.setAttribute("pass", pass);
                request.setAttribute("function", function);
                request.getRequestDispatcher("BadInfo.jsp").forward(request, response);
            }

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

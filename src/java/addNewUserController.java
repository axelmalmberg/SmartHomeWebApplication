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
@WebServlet(urlPatterns = {"/addNewUserController"})
public class addNewUserController extends HttpServlet {

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

//        //Coming to this controller through the login.jsp and loginController
//        //Code for handling new user in this controller.
//        String function = request.getParameter("function");
//
//        if (function.equalsIgnoreCase("add-info")) {
//            String user = request.getParameter("username");
//            String pass = request.getParameter("password");
//            String pass2 = request.getParameter("password2");
//
//            //ErrorMsg must not be blank. Else nullPointerException
//            String errorMsg = "Type in your information to add a user";
//            request.setAttribute("errorMsg", errorMsg);
//
//            if (pass.equals(pass2)) {
//                //Do create user code!
//
//                request.getRequestDispatcher("home.jsp").forward(request, response);
//            } else {
//                //If something faulty has happened do error code and retry again
//
//                errorMsg = "The register add new user was faulty, retry again";
//                request.setAttribute("errorMsg", errorMsg);
//                request.getRequestDispatcher("addNewUser.jsp").forward(request, response);
//
//            }
//
//        }
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
        requestToApi rta = new requestToApi();

        if (request.getParameter("button1") != null) {
            String user = request.getParameter("username");
            String pass = request.getParameter("password");
            String pass2 = request.getParameter("password2");
            String email = request.getParameter("email");

            if (user != null && pass != null && pass2 != null && email != null) {
                if (pass.equals(pass2)) {
                    rta.createUser(user, pass, email);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }

            request.setAttribute("username", user);
            request.setAttribute("pass", pass);
            request.getRequestDispatcher("BadInfo.jsp").forward(request, response);

        }

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

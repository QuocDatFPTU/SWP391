/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.Servlet;

import com.group04.entities.Role;
import com.group04.entities.User;
import com.group04.repositories.UserRepositoryImp;
import com.group04.validators.DoValidate;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HP
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    public static final String SUCCESS = "index";
    public static final String FAIL = "registerPage";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();
        Map<String, String> mapping = (Map<String, String>) context.getAttribute("MAPPING");
        String url = mapping.get(FAIL);
        try {
            System.out.println("Stating bug");
            UserRepositoryImp urp = new UserRepositoryImp();
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String repassword = request.getParameter("txtRePassword");
            String lastname = request.getParameter("txtLastname");
            String firstname = request.getParameter("txtFirstname");
            String gender = request.getParameter("txtGender");
            String email = request.getParameter("txtEmail");
            String phonenumber = request.getParameter("txtPhone");
            String avatar = "";
            User newUser = new User();
            System.out.println("Begin");
            System.out.println("Username"+username);
            if (urp.checkUsernameExist(username)) {
                System.out.println("Done check exist");
                request.setAttribute("mess", "The username already existed, try another one.");
            } else {
                if (repassword.equals(password)) {
                    newUser.setUsername(username);
                    Role newUserRole = urp.getRole("Customer");
                    System.out.println("Role: " + newUserRole.toString());
                    newUser.setRoles(Collections.singleton(newUserRole));
                    newUser.setPassword(password);
                    newUser.setFirstName(firstname);
                    newUser.setGender(gender);
                    newUser.setEmail(email);
                    newUser.setPhone(phonenumber);
                    newUser.setAvatar(avatar);
                    newUser.setActive(true);
                    newUser.setLastName(lastname);
                    System.out.println("New User: " + newUser.toString());
                    System.out.println("Before Error");
                    List<String> errors = DoValidate.validateU(newUser);
                    for (String error : errors) {
                        System.out.println(error.toString());
                    }
                    if (!errors.isEmpty()) {
                        session.setAttribute("ERROR_REGISTER", errors);
                    } else {
                        urp.register(newUser);
                        System.out.println("New User: " + newUser);
                        boolean checkAvail = urp.checkLogin(username, password);
                        if (checkAvail) {
                            System.out.println("The user is existed");
                        } else {
                            System.out.println("The user is not");
                        }
                        url = mapping.get(SUCCESS);
                    }
                } else {
                    request.setAttribute("mess", "Check your re-password again pls.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(url);
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
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

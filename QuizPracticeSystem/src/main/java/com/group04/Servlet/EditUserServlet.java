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
import static java.lang.Long.parseLong;
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
@WebServlet(name = "EditUserServlet", urlPatterns = {"/EditUserServlet"})
public class EditUserServlet extends HttpServlet {

    public static final String SUCCESS = "userprofile";
    public static final String FAIL = "index";

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();
        Map<String, String> mapping = (Map<String, String>) context.getAttribute("MAPPING");
        String url = mapping.get(FAIL);
        try {
            
            Long userID =parseLong(request.getParameter("userID"));
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String lastname = request.getParameter("lastname");
            String firstname = request.getParameter("firstname");
            String gender = request.getParameter("gender");
            String email = request.getParameter("email");
            String phonenumber = request.getParameter("phonenumber");
            String avatar = " ";
            User UpdateUser = new User();
            //Create New User
            UpdateUser.setUsername(username);
            UserRepositoryImp urp = new UserRepositoryImp();
            Role newUserRole = urp.getRole("Customer");
            System.out.println("Role: " + newUserRole.toString());
            UpdateUser.setRoles(Collections.singleton(newUserRole));
            UpdateUser.setPassword(password);
            UpdateUser.setFirstName(firstname);
            UpdateUser.setGender(gender);
            UpdateUser.setEmail(email);
            UpdateUser.setPhone(phonenumber);
            UpdateUser.setAvatar(avatar);
            UpdateUser.setActive(true);
            UpdateUser.setLastName(lastname);
            System.out.println("User update: " + UpdateUser.getFirstName() + UpdateUser.getLastName());
            System.out.println("Before Error");
            List<String> errors = DoValidate.validateU(UpdateUser);
            for (String error : errors) {
                System.out.println("Loi: " + error);
            }
            System.out.println("After Error");
            System.out.println("Number of Error: " + errors.size());
            if (!errors.isEmpty()) {
                session.setAttribute("ERROR_UPDATE", errors);
            } else {
                urp.updateUser(UpdateUser);
                url = mapping.get(SUCCESS);

            }
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

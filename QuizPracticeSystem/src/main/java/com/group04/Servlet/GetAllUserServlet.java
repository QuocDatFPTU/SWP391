/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.Servlet;

import static com.group04.Servlet.GetAllCategoryServlet.FAIL;
import com.group04.entities.Role;
import com.group04.entities.Subject;
import com.group04.entities.User;
import com.group04.payload.PayloadUserInfor;
import com.group04.repositories.SubjectRepositoryImp;
import com.group04.repositories.UserRepositoryImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
 * @author ntdun
 */
@WebServlet(name = "GetAllUserServlet", urlPatterns = {"/GetAllUserServlet"})
public class GetAllUserServlet extends HttpServlet {

    public static final String SUCCESS = "adminUser";
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
        ServletContext context = request.getServletContext();
        HttpSession session = request.getSession();
        Map<String, String> listmapping = (Map<String, String>) context.getAttribute("MAPPING");
        String url = listmapping.get(FAIL);
        try {
            UserRepositoryImp urp = new UserRepositoryImp();
            List<User> listuser;
            listuser = urp.getAllUser();
            List<String> listRole;
            ArrayList<PayloadUserInfor> ListPayloadUser = new ArrayList<>();
            for (User user : listuser) {
                listRole = new ArrayList<>();
                for (Role role : user.getRoles()) {
                    listRole.add(role.getName());
                }
                ListPayloadUser.add(new PayloadUserInfor(user, listRole.toString()));

            }
            session.setAttribute("listSize", listuser.size());
            session.setAttribute("listUser", ListPayloadUser);
            url = listmapping.get(SUCCESS);
        } catch (Exception e) {
            log("GetAllUserServlet_Exception: " + e);
        } finally {
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

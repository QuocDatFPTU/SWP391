/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.Controller;

import static com.group04.Controller.EditUserServlet.FAIL;
import static com.group04.Controller.EditUserServlet.SUCCESS;
import com.group04.entities.Subject;
import com.group04.repositories.SubjectRepositoryImp;
import com.group04.validators.DoValidate;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.Date;
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
@WebServlet(name = "EditSubjectServlet", urlPatterns = {"/EditSubjectServlet"})
public class EditSubjectServlet extends HttpServlet {
    public static final String SUCCESS = "detailpage";
    public static final String FAIL = "error";
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

            String subjectName = request.getParameter("subjectName");
            String category = request.getParameter("category");
            String owner = request.getParameter("owner");
            boolean status = Boolean.parseBoolean(request.getParameter("status"));
            Date updateDate = new Date();
            String description = request.getParameter("description");
            Long courseID = Long.parseLong(request.getParameter("courseID"));
            boolean isActive = Boolean.parseBoolean(request.getParameter("isActive"));
            Subject UpdateSubject = new Subject();

            SubjectRepositoryImp urp = new SubjectRepositoryImp();
            UpdateSubject.setSubjectName(subjectName);
            UpdateSubject.setCategory(category);
            UpdateSubject.setOwner(owner);
            UpdateSubject.setStatus(status);
            UpdateSubject.setDescription(description);
            UpdateSubject.setUpdateDate(updateDate);
            UpdateSubject.setCourseID(courseID);
            UpdateSubject.setActive(isActive);

            System.out.println("Subject update: " + UpdateSubject.getSubjectName());
            System.out.println("Before Error");
            List<String> errors = DoValidate.validateS(UpdateSubject);
            for (String error : errors) {
                System.out.println("Loi: " + error);
            }
            System.out.println("After Error");
            System.out.println("Number of Error: " + errors.size());
            if (!errors.isEmpty()) {
                session.setAttribute("ERROR_UPDATE", errors);
            } else {
                urp.updateSubject(UpdateSubject);
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

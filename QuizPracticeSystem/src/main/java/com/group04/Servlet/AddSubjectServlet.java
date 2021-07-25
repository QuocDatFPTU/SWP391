/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.Servlet;

import com.group04.entities.Course;
import com.group04.entities.Subject;
import com.group04.repositories.CourseRepositoryImp;
import com.group04.repositories.SubjectRepositoryImp;
import com.group04.validators.DoValidate;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Long.parseLong;
import java.util.Collections;
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
@WebServlet(name = "AddSubjectServlet", urlPatterns = {"/AddSubjectServlet"})
public class AddSubjectServlet extends HttpServlet {

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

            String subjectName = request.getParameter("txtsubjectName");
            String category = request.getParameter("txtcategory");
            String owner = request.getParameter("txtowner");
            Date updateDate = new Date();
            String description = request.getParameter("txtdescription");
            Long courseID = Long.parseLong(request.getParameter("txtcourseID"));
//                    parseLong(request.getParameter("courseID"));
            Subject subjectnew = new Subject();
            CourseRepositoryImp crs = new CourseRepositoryImp();
            SubjectRepositoryImp urp = new SubjectRepositoryImp();
            subjectnew.setSubjectName(subjectName);
            subjectnew.setCategory(category);
            subjectnew.setOwner(owner);
            subjectnew.setStatus(true);
            subjectnew.setUpdateDate(updateDate);
            subjectnew.setDescription(description);
            subjectnew.setActive(true);

            Course course = crs.getCourse(courseID);
            subjectnew.setCourse(course);
            System.out.println("Subject new: " + subjectnew.getSubjectName());
            System.out.println("Before Error");
            List<String> errors = DoValidate.validateS(subjectnew);
            for (String error : errors) {
                System.out.println("Loi: " + error);
            }
            System.out.println("After Error");
            System.out.println("Number of Error: " + errors.size());
            if (!errors.isEmpty()) {
                session.setAttribute("ERROR_UPDATE", errors);
            } else {
                urp.addSubject(subjectnew);
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

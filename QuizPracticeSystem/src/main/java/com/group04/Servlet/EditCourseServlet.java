/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.Servlet;

import static com.group04.Servlet.EditUserServlet.FAIL;
import static com.group04.Servlet.EditUserServlet.SUCCESS;
import com.group04.entities.Course;
import com.group04.repositories.CourseRepositoryImp;
import com.group04.validators.DoValidate;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "EditCourseServlet", urlPatterns = {"/EditCourseServlet"})
public class EditCourseServlet extends HttpServlet {
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

            String courseName = request.getParameter("courseName");
            boolean isFeatured = Boolean.parseBoolean(request.getParameter("isFeatured"));
            boolean isActive = Boolean.parseBoolean(request.getParameter("isActive"));
            String thumbnailLink = request.getParameter("tumbnailLink");
            String createDate = request.getParameter("createDate");

            Course UpdateCourse = new Course();

            CourseRepositoryImp urp = new CourseRepositoryImp();
            UpdateCourse.setCourseName(courseName);
            UpdateCourse.setFeatured(isFeatured);
            UpdateCourse.setActive(isActive);
            UpdateCourse.setThumbnailLink(thumbnailLink);
            UpdateCourse.setCreateDate(createDate);

            System.out.println("Course update: " + UpdateCourse.getCourseName());
            System.out.println("Before Error");
            List<String> errors = DoValidate.validateC(UpdateCourse);
            for (String error : errors) {
                System.out.println("Loi: " + error);
            }
            System.out.println("After Error");
            System.out.println("Number of Error: " + errors.size());
            if (!errors.isEmpty()) {
                session.setAttribute("ERROR_UPDATE", errors);
            } else {
                urp.updateCourse(UpdateCourse);
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

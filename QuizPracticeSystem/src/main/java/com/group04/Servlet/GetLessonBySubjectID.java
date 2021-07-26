/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.Servlet;

import com.group04.entities.Lesson;
import com.group04.repositories.LessonRepositoryImp;
import com.group04.repositories.SubjectRepositoryImp;
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
@WebServlet(name = "GetLessonBySubjectID", urlPatterns = {"/GetLessonBySubjectID"})
public class GetLessonBySubjectID extends HttpServlet {
    public static final String SUCCESS = "subjectlesson";
    public static final String FAIL = "viewdetailcourse";
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
//            Long subjectID =parseLong(request.getParameter("subjectID"));
            LessonRepositoryImp urp= new LessonRepositoryImp();
            SubjectRepositoryImp sub =new SubjectRepositoryImp();
            List<Lesson> listlesson;
            
            listlesson=new ArrayList<>(sub.getSubjectById(1L).getLesson());
//            Subject subject =sub.getSubjectById(subjectID);
            System.out.println(listlesson);
//            String subjectname= subject.getSubjectName();
//            session.setAttribute("listLesson", listlesson);
//            session.setAttribute("subjectname", subjectname);
        }catch (Exception e){ 
            e.printStackTrace();
        }finally{
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

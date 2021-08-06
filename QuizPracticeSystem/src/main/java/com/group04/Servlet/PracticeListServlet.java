/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.Servlet;

import com.group04.entities.Dimension;
import com.group04.entities.ExamInfo;
import com.group04.entities.Subject;
import com.group04.repositories.DimensionRepository;
import com.group04.repositories.DimensionRepositoryImp;
import com.group04.repositories.QuizRepository;
import com.group04.repositories.SubjectRepository;
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
 * @author Polaris
 */
@WebServlet(name = "PracticeListServlet", urlPatterns = {"/PracticeListServlet"})
public class PracticeListServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Step 1: Get Subject Líst trong database lên 
        //2: Lưu vào request scope 
        //3: Forward qua trang quizlist.jsp 
        ServletContext context = request.getServletContext();
        HttpSession session = request.getSession();
        Map<String, String> mapping = (Map<String, String>) context.getAttribute("MAPPING");
        QuizRepository quizRepo = QuizRepository.createInstance();
        SubjectRepository subRepo = new SubjectRepositoryImp();
        DimensionRepository dimRepo = new DimensionRepositoryImp();
        List<ExamInfo> exams = new ArrayList<>(quizRepo.getAllExam());
        List<Subject> subjects = new ArrayList<>(subRepo.getAllSubject());
        List<Dimension> dimensions = null;
        try {
       
            Long subjectParam = Long.parseLong(request.getParameter("subjectID"));
            dimensions = dimRepo.getDimensionBySubjectID(subjectParam);
            for(Dimension dim : dimensions){
                System.out.println(dim);
            }
        } catch (Exception e) {
            e.printStackTrace();
            dimensions = new ArrayList<>();
        }

        session.setAttribute("EXAM_LIST", exams);
        session.setAttribute("SUBJECT_LIST", subjects);
        session.setAttribute("DIMENSION_LIST", dimensions);
        RequestDispatcher rd = request.getRequestDispatcher(mapping.get("quizListPage"));
        rd.forward(request, response);

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

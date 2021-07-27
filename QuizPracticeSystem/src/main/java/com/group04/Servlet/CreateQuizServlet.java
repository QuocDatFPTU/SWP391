/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.Servlet;

import com.group04.entities.ExamDetail;
import com.group04.entities.ExamInfo;
import com.group04.payloads.QuizDetailDTO;
import com.group04.repositories.ExamInfoImp;
import com.group04.repositories.ExamRepository;
import com.group04.repositories.SubjectRepository;
import com.group04.repositories.SubjectRepositoryImp;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author Admin
 */
@WebServlet(name = "CreateQuizServlet", urlPatterns = {"/CreateQuizServlet"})
public class CreateQuizServlet extends HttpServlet {

    private final String SUCCESS = "createQuizPage";
    private final String BACK = ""; //need change

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
        ServletContext context = request.getServletContext();
        Map<String, String> mapping = (Map<String, String>) context.getAttribute("MAPPING");
        String url = mapping.get(SUCCESS);
        PrintWriter out = response.getWriter();
        String examName = request.getParameter("txtQuizName");
        String subjectID = request.getParameter("txtSubjectName");
        String examLevel = request.getParameter("txtExamLevel");
        String duration = request.getParameter("txtDuration");
        String examType = request.getParameter("txtQuizType");
        String passRate = request.getParameter("txtPassrate");
        String description = request.getParameter("txtDescription");
        String btnAction = request.getParameter("btnAction");
        try {
            if (btnAction.equalsIgnoreCase("back")) {
                url = mapping.get(BACK);
            } else {
                HttpSession session = request.getSession();
                QuizDetailDTO currentQuizDetail = (QuizDetailDTO) session.getAttribute("QUIZ_DETAIL_ADMIN");
                currentQuizDetail.setQuizName(examName);
                currentQuizDetail.setSubjectName(subjectID);
                currentQuizDetail.setExamLevel(examLevel);
                currentQuizDetail.setDuration(Integer.parseInt(duration));
                currentQuizDetail.setQuizType(examType);
                currentQuizDetail.setPassRate(Float.parseFloat(passRate));
                currentQuizDetail.setDescription(description);
                System.out.println(currentQuizDetail.toString());
                ExamInfoImp ExamDAO = new ExamInfoImp();
                ExamInfo currentExamInfo = new ExamInfo();
                SubjectRepository currentSubject = new SubjectRepositoryImp();
                currentExamInfo.setDescription(description);
                currentExamInfo.setDuration(duration);
                currentExamInfo.setExamLevel(examLevel);
                currentExamInfo.setExamName(examName);
                currentExamInfo.setPassRate(Float.parseFloat(passRate));
                currentExamInfo.setExamType(examType);
                currentExamInfo.setSubject(currentSubject.getSubjectById(Long.parseLong(subjectID)));
                ExamDAO.createExam(currentExamInfo);
                currentQuizDetail.setIsFillFull(true);
                session.setAttribute("QUIZ_DETAIL_ADMIN", currentQuizDetail);
            }
        } catch (NumberFormatException ne) {
            log("CreateQuizOverServlet_NumberfomatExcaption: " + ne);
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

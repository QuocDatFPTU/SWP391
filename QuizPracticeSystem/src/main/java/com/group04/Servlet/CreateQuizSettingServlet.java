/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.Servlet;

import com.group04.entities.ExamSetting;
import com.group04.entities.Lesson;
import com.group04.entities.Subject;
import com.group04.payloads.QuizDetailDTO;
import com.group04.repositories.ExamSettingImp;
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
 * @author Admin
 */
@WebServlet(name = "CreateQuizSettingServlet", urlPatterns = {"/CreateQuizSettingServlet"})
public class CreateQuizSettingServlet extends HttpServlet {

    public final String SUCCESS = "createQuizPage";
    public final String BACK = "";//need modify

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
        String numberOfQuestion = request.getParameter("txtNumberOfQuestion");
        String[] numberOfQuestionPerChoice = request.getParameterValues("txtNumberOfQuestionPerchoice");
        String optionChoice = request.getParameter("inlineRadioOptions");
        String btnAction = request.getParameter("btnAction");
        ServletContext context = request.getServletContext();
        HttpSession session = request.getSession();
        Map<String, String> mapping = (Map<String, String>) context.getAttribute("MAPPING");
        String url = mapping.get(SUCCESS);
        try {
            List<Subject> listSubject = (List<Subject>) session.getAttribute("LIST_SUBJECT");
            QuizDetailDTO currentQuizDetail = (QuizDetailDTO) session.getAttribute("QUIZ_DETAIL_ADMIN");
            Subject currentSubject = listSubject.get(Integer.parseInt(currentQuizDetail.getSubjectName()));
            List<Lesson> currentListLesson = new ArrayList<>(currentSubject.getLesson());
            if (btnAction.equalsIgnoreCase("add")) {
                if (optionChoice.equalsIgnoreCase("topic")) {
                    List<String> listTopic = new ArrayList<>();
                    for (Lesson lesson : currentListLesson) {
                        listTopic.add(lesson.getTopic());
                        session.setAttribute("LIST_CHOICE", listTopic);
                    }
                }
                if (optionChoice.equalsIgnoreCase("group")) {
                    List<String> ListGroup = new ArrayList<>();
                    for (Lesson lesson : currentListLesson) {
                        ListGroup.add(lesson.getOrder());
                        session.setAttribute("LIST_CHOICE", ListGroup);
                    }
                }
            } else if (btnAction.equalsIgnoreCase("back")) {
                url = mapping.get(BACK);
            } else if (btnAction.equalsIgnoreCase("submit")) {
                int totalNumberQuestionInRequest = 0;
                for (String string : numberOfQuestionPerChoice) {
                    totalNumberQuestionInRequest = totalNumberQuestionInRequest + Integer.parseInt(string);
                }
                if (Integer.parseInt(numberOfQuestion) < totalNumberQuestionInRequest) {
                    request.setAttribute("ERRORS", "Input number of question smaller than" + numberOfQuestion);
                } else {
                    List<String> listChoice = (List<String>) session.getAttribute("LIST_CHOICE");
                    for (int i = 0; i < listChoice.size(); i++) {
                        ExamSetting examSetting = new ExamSetting();
                        examSetting.setExamType(optionChoice);
                        examSetting.setNameSetting(listChoice.get(i));
                        examSetting.setNumberOfQuestion(Integer.parseInt(numberOfQuestionPerChoice[i]));
                        ExamSettingImp dao = new ExamSettingImp();
                        dao.createExamSetting(examSetting);
                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
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

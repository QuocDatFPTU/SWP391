/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.Servlet;

import com.group04.entities.Question;
import com.group04.entities.QuestionStatus;
import com.group04.repositories.QuestionRepository;
import com.group04.repositories.QuizRepository;
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
 * @author HP
 */
@WebServlet(name = "GetRandomQuestionServlet", urlPatterns = {"/GetRandomQuestionServlet"})
public class GetRandomQuestionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        System.out.println("Hello Cac be loli");
        QuizRepository questRepo = QuizRepository.createInstance();
        List<Question> quests = questRepo.getRandomQuestionsBySubject((Long) 4L, 10);

        for (Question quest : quests) {
            System.out.println("est Optin: " + quest.getOption().size());
        }
        //gia su da get dc quests

        //get session
        HttpSession session = request.getSession();
        //gan object vao session va dat ten cho attribute
        session.setAttribute("questionList", quests);
        //Tao them 1 status List de danh dau cau hoi lam or chua
        List<QuestionStatus> questionStatus = new ArrayList<>();
        //Ứng với 1 câu hỏi khởi tạo 1 status = false va null
        for (int i = 0; i < quests.size(); i++) {
            questionStatus.add(new QuestionStatus(false, null));
        }
        //set Atrribute
        session.setAttribute("questionStatus", questionStatus);
        //mapping
        ServletContext context = request.getServletContext();
        Map<String, String> mapping = (Map<String, String>) context.getAttribute("MAPPING");
        //forward 
        String url = mapping.get("loadQuestion");
        RequestDispatcher rd = request.getRequestDispatcher(url);
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

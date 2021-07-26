/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.Servlet;

import com.group04.entities.Option;
import com.group04.entities.Question;
import com.group04.entities.QuestionStatus;
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
 * @author Polaris
 */
@WebServlet(name = "LoadQuestionServlet", urlPatterns = {"/LoadQuestionServlet"})
public class LoadQuestionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        try {
            //1.Lấy attribute ra 
            List<Question> quests = (List<Question>) session.getAttribute("questionList");
            Integer recentQuestion = (Integer) session.getAttribute("recentQuestion");//cau hoi user dang lam, de Integer de nhan gia tri null
            if (recentQuestion == null) {
                //question tinh tu 0 nen = -1
                recentQuestion = -1;
            }
            //2.Cập nhật câu trả lời
            if (recentQuestion != -1) {
                //get chosen AnswerID
                String answerIdString = request.getParameter("Ans");
                if (answerIdString != null) {
                    //check khac null moi parse dc 
                    Long answerId = Long.parseLong(answerIdString);
                    //option tam thoi chua id cau tra loi
                    Option chosenAnswer = new Option(answerId);
                    
                    List<QuestionStatus> questionStatusList = (List<QuestionStatus>) session.getAttribute("questionStatus");
                    QuestionStatus questionStatus = questionStatusList.get(recentQuestion);

                    //lay cau hoi dang lam trong danh sach cau hoi
                    Question quest = quests.get(recentQuestion);
                    //tim cau hoi dang dc chon 
                    for (Option option : quest.getOption()) {
                        //tim cau tra loi trong options so với câu trả lời đang 
                        if (chosenAnswer.equals(option)) {
                            questionStatus.setChosenOption(option);
                            
                            session.setAttribute("questionStatus", questionStatusList);
                            
                            break;
                        }
                    }
                }
            }
            //3.Lấy câu hỏi kế tiêp
            recentQuestion++;
            session.setAttribute("recentQuestion", recentQuestion);

        } catch (Exception e) {

        } finally {
            //mapping
            ServletContext context = request.getServletContext();
            Map<String, String> mapping = (Map<String, String>) context.getAttribute("MAPPING");
            //forward 
            String url = mapping.get("quizPage");
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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

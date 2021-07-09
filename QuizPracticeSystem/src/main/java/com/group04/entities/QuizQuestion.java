/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.entities;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author HP
 */
@Entity
@Table(name = "tblLesson")
public class QuizQuestion implements Serializable{
    @Id
    @Column(name = "quizQuestionID")
    private String quizQuestionID;
    
    @Column(name = "content")
    private String content;
    
    @Column(name = "explanation")
    private String explanation;
    
    @Column(name = "examID")
    private String examID;

    public QuizQuestion() {
    }

    public QuizQuestion(String quizQuestionID, String content, String explanation, String examID) {
        this.quizQuestionID = quizQuestionID;
        this.content = content;
        this.explanation = explanation;
        this.examID = examID;
    }

    public String getQuizQuestionID() {
        return quizQuestionID;
    }

    public void setQuizQuestionID(String quizQuestionID) {
        this.quizQuestionID = quizQuestionID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getExamID() {
        return examID;
    }

    public void setExamID(String examID) {
        this.examID = examID;
    }
    
}

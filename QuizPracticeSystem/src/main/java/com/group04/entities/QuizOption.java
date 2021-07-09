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
public class QuizOption implements Serializable{
    @Id
    @Column(name = "quizOptionID")
    private String quizOptionID;
    
    @Column(name = "content")
    private String content;

    @Column(name = "quizQuestionID")
    private String quizQuestionID;
    public QuizOption() {
    }

    public QuizOption(String quizOptionID, String content, String quizQuestionID) {
        this.quizOptionID = quizOptionID;
        this.content = content;
        this.quizQuestionID = quizQuestionID;
    }

    public String getQuizOptionID() {
        return quizOptionID;
    }

    public void setQuizOptionID(String quizOptionID) {
        this.quizOptionID = quizOptionID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getQuizQuestionID() {
        return quizQuestionID;
    }

    public void setQuizQuestionID(String quizQuestionID) {
        this.quizQuestionID = quizQuestionID;
    }
    
}

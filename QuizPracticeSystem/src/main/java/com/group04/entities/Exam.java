/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author HP
 */
@Entity
@Table(name = "tblExam")
public class Exam {
    @Id
    @Column(name = "examID")
    private String examID;
    
    @Column(name = "passRate")
    private String passRate;
    
    @Column(name = "duration")
    private String duration;
    
    @Column(name = "type")
    private String type;
    
    @Column(name = "quizID")
    private String quizID;
    
    @Column(name = "quizQuestionID")
    private String quizQuestionID;

    public Exam() {
    }

    public Exam(String examID, String passRate, String duration, String type, String quizID, String quizQuestionID) {
        this.examID = examID;
        this.passRate = passRate;
        this.duration = duration;
        this.type = type;
        this.quizID = quizID;
        this.quizQuestionID = quizQuestionID;
    }

    public String getExamID() {
        return examID;
    }

    public void setExamID(String examID) {
        this.examID = examID;
    }

    public String getPassRate() {
        return passRate;
    }

    public void setPassRate(String passRate) {
        this.passRate = passRate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuizID() {
        return quizID;
    }

    public void setQuizID(String quizID) {
        this.quizID = quizID;
    }

    public String getQuizQuestionID() {
        return quizQuestionID;
    }

    public void setQuizQuestionID(String quizQuestionID) {
        this.quizQuestionID = quizQuestionID;
    }
    
}

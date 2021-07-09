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
@Table(name = "tblQuiz")
public class Quiz implements Serializable{
    @Id
    @Column(name = "quizID")
    private String quizID;
    
    @Id
    @Column(name = "level")
    private String level;
    
    @Id
    @Column(name = "examID")
    private String examID;
    
    @Id
    @Column(name = "lessonID")
    private String lessonID;
    
    @Id
    @Column(name = "subjectID")
    private String subjectID;

    public Quiz() {
    }

    public Quiz(String quizID, String level, String examID, String lessonID, String subjectID) {
        this.quizID = quizID;
        this.level = level;
        this.examID = examID;
        this.lessonID = lessonID;
        this.subjectID = subjectID;
    }

    public String getQuizID() {
        return quizID;
    }

    public void setQuizID(String quizID) {
        this.quizID = quizID;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getExamID() {
        return examID;
    }

    public void setExamID(String examID) {
        this.examID = examID;
    }

    public String getLessonID() {
        return lessonID;
    }

    public void setLessonID(String lessonID) {
        this.lessonID = lessonID;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }
    
}

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
@Table(name = "tblQuestion")
public class Question implements Serializable{
    @Id
    @Column(name = "questionID")
    private String questionID;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "content")
    private String content;
    
    @Column(name = "level")
    private String level;
    
    @Column(name = "explanation")
    private String explanation;
    
    @Column(name = "subjectID")
    private String subjectID;

    public Question() {
    }

    public Question(String questionID, String status, String content, String level, String explanation, String subjectID) {
        this.questionID = questionID;
        this.status = status;
        this.content = content;
        this.level = level;
        this.explanation = explanation;
        this.subjectID = subjectID;
    }

    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }
    
}

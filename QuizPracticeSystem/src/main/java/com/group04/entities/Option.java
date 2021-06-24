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
@Table(name = "tblOption")
public class Option {
    @Id
    @Column(name = "OptionID")
    private String OptionID;
    
    @Column(name = "content")
    private String content;
    
    @Column(name = "isCorrect")
    private String isCorrect;
    
    @Column(name = "questionID")
    private String questionID;

    public Option() {
    }

    public Option(String OptionID, String content, String isCorrect, String questionID) {
        this.OptionID = OptionID;
        this.content = content;
        this.isCorrect = isCorrect;
        this.questionID = questionID;
    }

    

    public String getOptionID() {
        return OptionID;
    }

    public void setOptionID(String OptionID) {
        this.OptionID = OptionID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(String isCorrect) {
        this.isCorrect = isCorrect;
    }

    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }
    
}

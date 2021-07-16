/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "OptionExam")
@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
public class OptionExam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long optionID;
    
    @Column(name = "content")
    private String content;
    
    @Column(name = "isRight")
    private boolean isRight;
    
    @Column(name = "questionID")
    private String questionID;
       
    @ManyToOne
    @JoinColumn(name = "questionID")
    private QuestionExam questionExam;
    
    public OptionExam(OptionExam option) {
        this.optionID = option.optionID;
        this.content = option.content;
        this.isRight = option.isRight;
        this.questionID = option.questionID;
}
}

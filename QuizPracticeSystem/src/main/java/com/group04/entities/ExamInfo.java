/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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
@Table(name = "ExamInfo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExamInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examInfoID;
    
    @Column(name = "numberOfQuestion")
    private int numberOfQuestion;
    
    @Column(name = "isFinished")
    private boolean isFinished;
    
    @Column(name = "passRate")
    private float passRate;
    
    @Column(name = "duration")
    private String duration;
    
    @Column(name = "examLevel")
    private String examLevel;
    
    @Column(name = "examType")
    private String examType;
    
    @Column(name = "description")
    private String description;
        
    @ManyToMany(mappedBy ="ExamInfo")
    private Set<Lesson> lessons = new HashSet<>();
    
    @ManyToOne
    @JoinColumn(name="userID")
    private User user;
    
    @OneToOne
    @JoinColumn(name = "examDetailID")
    private ExamDetail examDetail;
    
    public ExamInfo(ExamInfo examInfoID) {
        this.examInfoID = examInfoID.examInfoID;
        this.numberOfQuestion = examInfoID.numberOfQuestion;
        this.isFinished = examInfoID.isFinished;
        this.passRate = examInfoID.passRate;
        this.duration = examInfoID.duration;
        this.examLevel = examInfoID.examLevel;
        this.examType = examInfoID.examType;
        this.description = examInfoID.description;
    }
}

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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "ExamDetail")
@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
public class ExamDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examDetailID;
    
    @Column(name = "examName")
    private String examName;
    
    @Column(name = "score")
    private float score;
    
    @Column(name = "createDate")
    private String createDate;
    
    @Column(name = "timeStart")
    private String timeStart;
    
    @Column(name = "timeEnd")
    private String timeEnd;
    
    @Column(name = "totalTime")
    private String totalTime;
    
    @OneToOne(mappedBy = "examDetail", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn 
    private ExamInfo examInfo;
    
    @OneToOne(mappedBy = "examDetail", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn 
    private ExamSetting examSetting;
    
    @OneToMany(mappedBy = "examDetail", fetch = FetchType.EAGER)
    private Set<QuestionExam> QuestionExam = new HashSet<>();
    
    public ExamDetail(ExamDetail examDetail) {
        this.examDetailID = examDetail.examDetailID;
        this.examName = examDetail.examName;
        this.score = examDetail.score;
        this.createDate = examDetail.createDate;
        this.timeStart = examDetail.timeStart;
        this.timeEnd = examDetail.timeEnd;
        this.totalTime = examDetail.totalTime;
    }
}

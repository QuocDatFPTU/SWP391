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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "lesson")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lesson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lessonID", nullable = false, updatable = false)
    private long lessonID;

    @Column(name = "lessonName")
    private String lessonName;

    @Column(name = "topic")
    private String topic;

    @Column(name = "order")
    private String order;

    @Column(name = "youtubeLink")
    private String youtubeLink;
    
    @Column(name = "HTMLContent")
    private String HTMLContent;

    @Column(name = "type")
    private String type;
    
    @Column(name = "isActive")
    private boolean isActive;
    
    @Column(name = "subjectID")
    private boolean subjectID;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Exams_Lessons",
            joinColumns = {
                @JoinColumn(name = "lessonID")},
            inverseJoinColumns = {
                @JoinColumn(name = "examInfoID")}
    )
    private Set<ExamInfo> examInfos = new HashSet<>();
    
    @OneToMany(mappedBy = "lessonID", fetch = FetchType.EAGER)
    private Set<Question> Question = new HashSet<>();
    
    @ManyToOne
    @JoinColumn(name="subjectID")
    private Subject subject;
    
    public Lesson(Lesson lesson) {
        this.lessonID = lesson.lessonID;
        this.lessonName = lesson.lessonName;
        this.topic = lesson.topic;
        this.order = lesson.order;
        this.youtubeLink = lesson.youtubeLink;
        this.HTMLContent = lesson.HTMLContent;
        this.type = lesson.type;
        this.isActive = lesson.isActive;
        this.subjectID = lesson.subjectID;
}
}

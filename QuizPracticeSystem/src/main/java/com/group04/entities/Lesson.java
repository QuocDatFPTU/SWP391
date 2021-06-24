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
@Table(name = "tblLesson")
public class Lesson {
    @Id
    @Column(name = "lessonID")
    private String lessonID;
    
    @Column(name = "lessonName")
    private String lessonName;
    
    @Column(name = "topic")
    private String topic;
    
    @Column(name = "type")
    private String type;
    
    @Column(name = "order")
    private String order;
    
    @Column(name = "videoLink")
    private String videoLink;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "subjectID")
    private String subjectID;

    public Lesson() {
    }

    public Lesson(String lessonID, String lessonName, String topic, String type, String order, String videoLink, String description, String subjectID) {
        this.lessonID = lessonID;
        this.lessonName = lessonName;
        this.topic = topic;
        this.type = type;
        this.order = order;
        this.videoLink = videoLink;
        this.description = description;
        this.subjectID = subjectID;
    }

    public String getLessonID() {
        return lessonID;
    }

    public void setLessonID(String lessonID) {
        this.lessonID = lessonID;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }
    
}

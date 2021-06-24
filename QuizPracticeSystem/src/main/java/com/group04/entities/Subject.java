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
@Table(name = "tblSubject")
public class Subject {
    @Id
    @Column(name = "subjectID")
    private String subjectID;
    
    @Column(name = "subjectName")
    private String subjectName;
    
    @Column(name = "category")
    private String category;
    
    @Column(name = "owner")
    private String owner;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "dimension")
    private String dimension;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "courseID")
    private String courseID;

    public Subject() {
    }

    public Subject(String subjectID, String subjectName, String category, String owner, String status, String dimension, String description, String courseID) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.category = category;
        this.owner = owner;
        this.status = status;
        this.dimension = dimension;
        this.description = description;
        this.courseID = courseID;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
    
    
}

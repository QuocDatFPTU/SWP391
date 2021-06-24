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
@Table(name = "tblCourse")
public class Course {
    @Id
    @Column(name = "courseID")
    private String courseID;
    
    @Column(name = "courseName")
    private String courseName;
    
    @Column(name = "thumbnail")
    private String thumbnail;
    
    @Column(name = "category")
    private String category;
    
    @Column(name = "featuredFlag")
    private String featuredFlag;
    
    @Column(name = "owner")
    private String owner;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "originalPrice")
    private String originalPrice;
    
    @Column(name = "salePrice")
    private String salePrice;
    
    @Column(name = "subjectID")
    private String subjectID;

    public Course() {
    }

    public Course(String courseID, String courseName, String thumbnail, String category, String featuredFlag, String owner, String status, String description, String originalPrice, String salePrice, String subjectID) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.thumbnail = thumbnail;
        this.category = category;
        this.featuredFlag = featuredFlag;
        this.owner = owner;
        this.status = status;
        this.description = description;
        this.originalPrice = originalPrice;
        this.salePrice = salePrice;
        this.subjectID = subjectID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFeaturedFlag() {
        return featuredFlag;
    }

    public void setFeaturedFlag(String featuredFlag) {
        this.featuredFlag = featuredFlag;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.entities;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "course")
@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseID;
    
    @NotBlank(message = "coursename cannot be empty")
    @Size(max = 100, min = 5, message = "course name must be 5 characters")
    @Column(name = "courseName")
    private String courseName;
    
    
    @Column(name = "isFeatured")
    private boolean isFeatured;

    @Column(name = "isActive")
    private boolean isActive;
    
    @Size(max = 100, min = 10)
    @Column(name = "thumbnailLink")
    private String thumbnailLink;

    @Column(name = "createDate")
    private String createDate;
    
    @OneToMany(mappedBy="Course")
    private Set<Package> packages;
    
    @OneToMany(mappedBy="Course")
    private Set<Subject> subject;

    public Course(Course course) {
        this.courseID = course.courseID;
        this.courseName = course.courseName;
        this.isFeatured = course.isFeatured;
        this.isActive = course.isActive;
        this.thumbnailLink = course.thumbnailLink;
        this.createDate = course.createDate;
    }   
}

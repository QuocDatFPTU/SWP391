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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.mapping.Set;
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
    
    @NotBlank(message = "category cannot be empty")
    @Size(max = 100)
    @Column(name = "category")
    private String category;
    
    @NotBlank(message = "featuredFlag cannot be empty")
    @Size(max = 40, min = 1, message = "featuredFlag must have more than 1 character")
    @Column(name = "featuredFlag")
    private boolean featuredFlag;

    @Column(name = "isActive")
    private boolean isActive;
    
    @NotBlank(message = "description cannot be empty")
    @Size(max = 100, min = 10)
    @Email
    @Column(name = "description")
    private String description;

    @NotBlank(message = "price cannot be empty")
    @Size(max = 12, min = 1, message = "cannot be lower than 1 dollar")
    @Column(name = "price")
    private String price;

    @NotBlank(message = "idSale cant be empty")
    @Size(max = 40, min = 1)
    @Column(name = "idSale")
    private String idSale;

    @Column(name = "createDate")
    private String createDate;
    
    @Column(name = "updateDate")
    private String updateDate;

    //@OneToMany(mappedBy = "Course")
    //private Set<Register> register;
    public Course(Course course) {
        this.courseID = course.courseID;
        this.courseName = course.courseName;
        this.category = course.category;
        this.featuredFlag = course.featuredFlag;
        this.isActive = course.isActive;
        this.description = course.description;
        this.price = course.price;
        this.idSale = course.idSale;
        this.createDate = course.createDate;
        this.updateDate = course.updateDate;
    }
    
}

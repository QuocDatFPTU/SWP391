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
import javax.persistence.JoinTable;
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
@Table(name = "StudentRegistration")
@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
public class StudentRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "StudentID")
    private Long StudentID;
    
    @Column(name = "courseID")
    private long courseID;
    
    @Column(name = "PaymentID")
    private String PaymentID;
    
    @Column(name = "FeeStatus")
    private boolean FeeStatus;
    
    @Column(name = "registerDate")
    private String registerDate;
    
    @ManyToOne
    @JoinTable(
     name = "users",
     joinColumns = {@JoinColumn(name = "id")}    
    )
    
    private Course course;
      
    public StudentRegistration(StudentRegistration register) {
        this.id = register.id;
        this.StudentID = register.StudentID;
        this.courseID = register.courseID;
        this.registerDate = register.registerDate;
        this.FeeStatus = register.FeeStatus;
    }
      
}

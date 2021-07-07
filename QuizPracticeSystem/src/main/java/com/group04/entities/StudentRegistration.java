/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    private Long registrationID;
    
    @Column(name = "userID")
    private Long userID;
      
    @Column(name = "paymentID")
    private String paymentID;
    
    @Column(name = "isPaid")
    private boolean isPaid;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
     name = "users",
     joinColumns = {@JoinColumn(name = "id")}    
    )
    
    @OneToMany(mappedBy = "StudentRegistration")
    private Set<Course> Course;
    
    @OneToOne
    @MapsId
    @JoinColumn(name = "paymentID")
    private Payment payment;
    
      
    public StudentRegistration(StudentRegistration register) {
        this.registrationID = register.registrationID;
        this.userID = register.userID;
        this.paymentID = register.paymentID;
        this.isPaid = register.isPaid;
    }
      
}

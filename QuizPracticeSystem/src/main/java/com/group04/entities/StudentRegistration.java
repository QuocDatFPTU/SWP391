    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class StudentRegistration implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long registrationID;

    @Column(name = "userID")
    private Long userID;
    
    @Column(name = "isPaid")
    private boolean isPaid;
    
    @Column(name = "courseID")
    private int courseID;

    @Column(name = "paymentID")
    private int paymentID;

    @OneToOne
    @JoinColumn(name = "paymentID")
    private Payment payment;
    
    @OneToMany(mappedBy="courseID", fetch = FetchType.LAZY)
    private Set<Course> course = new HashSet<>();

    public StudentRegistration(StudentRegistration register) {
        this.registrationID = register.registrationID;
        this.userID = register.userID;
        this.payment = register.payment;
        this.isPaid = register.isPaid;
    }

}

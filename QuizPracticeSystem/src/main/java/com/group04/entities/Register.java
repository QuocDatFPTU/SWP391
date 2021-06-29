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
@Table(name = "Register")
@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long RegisterID;
    
    @Column(name = "id")
    private Long id;
    
    @Column(name = "courseID")
    private long courseID;
    
    @Column(name = "registerDay")
    private String registerDay;

    
    public Register(Register register) {
        this.RegisterID = register.RegisterID;
        this.id = register.id;
        this.courseID = register.courseID;
        this.registerDay = register.registerDay;
    }
    
   
}

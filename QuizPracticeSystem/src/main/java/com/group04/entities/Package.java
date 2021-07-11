/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "Package")
@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
public class Package implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long packageID;
    
    @NotBlank(message = "packageName can't be empty")
    @Size(max = 100, min = 1, message="packageName must have more than 1 characters")
    @Column(name = "packageName")
    private String packageName;
    
    @NotBlank(message = "packageName can't be empty")
    @Column(name = "price")
    private String price;
    
    @Column(name = "courseID")
    private String courseID;
    
    public Package(Package packages) {
        this.packageID = packages.packageID;
        this.packageName = packages.packageName;
        this.price = packages.price;
        this.courseID = packages.courseID;
        
    }
}

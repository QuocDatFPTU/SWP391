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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    
    @NotBlank(message = "subjectname can't be empty")
    @Size(max = 100, min = 5, message="subjectname must have more than 5 characters")
    @Column(name = "subjectName")
    private String subjectName;
    
    @NotBlank(message = "category can't be empty")
    @Size(max = 100, min = 1, message="category must have more than 1 characters")
    @Column(name = "category")
    private String category;
    
    @NotBlank(message = "owner can't be empty")
    @Size(max = 100, min = 1, message="owner must have more than 1 characters")
    @Column(name = "owner")
    private String owner;
    
    @Column(name = "status")
    private String status;
    
    @NotBlank(message = "dimension can't be empty")
    @Size(max = 100, min = 5, message="dimension must have more than 5 characters")
    @Column(name = "dimension")
    private String dimension;
    
    @NotBlank(message = "description can't be empty")
    @Size(max = 100, min = 5, message="description must have more than 5 characters")
    @Column(name = "description")
    private String description;
    
    @Column(name = "courseID")
    private String courseID;
       
}

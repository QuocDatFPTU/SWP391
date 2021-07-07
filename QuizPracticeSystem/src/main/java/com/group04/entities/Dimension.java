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
@Entity
@Table(name = "Dimension")
@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
public class Dimension {
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dimensionID;
    
    @NotBlank(message = "dimensionName can't be empty")
    @Size(max = 100, min = 5, message="dimensionName must have more than 5 characters")
    @Column(name = "dimensionName")
    private String dimensionName;
    
    @Column(name = "subjectID")
    private String subjectID;
    
    public Dimension(Dimension dimension) {
        this.dimensionID = dimension.dimensionID;
        this.dimensionName = dimension.dimensionName;
        this.subjectID = dimension.subjectID;
        
    } 
}

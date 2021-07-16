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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 *
 * @author HP
 */
@Entity
@Table(name = "Blog")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Blog implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String blogID;
    
    @Column(name = "blogDetail")
    private String blogDetail;

       
}

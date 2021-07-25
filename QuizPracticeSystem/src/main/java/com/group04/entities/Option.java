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
import javax.persistence.JoinColumn;
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
@Table(name = "Option")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Option implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "optionID", nullable = false, updatable = false)
    private Long optionID;

    @Column(name = "content")
    private String content;

    @Column(name = "isRight")
    private boolean isRight;

    
    @ManyToOne
    @JoinColumn(name = "questionID")
    private Question question;

    public Option(Option option) {
        this.optionID = option.optionID;
        this.content = option.content;
        this.isRight = option.isRight;

    }
}

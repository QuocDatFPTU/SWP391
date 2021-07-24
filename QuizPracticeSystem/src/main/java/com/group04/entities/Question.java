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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "Question")
@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
public class Question implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionID;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "content")
    private String content;
    
    @Column(name = "level")
    private String level;
    
    @Column(name = "explanation")
    private String explanation;
    
    @ManyToOne
    @JoinColumn(name = "lessonID")
    private Lesson lesson;

   @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private Set<Option> Option = new HashSet<>();
   
   public Question(Question question) {
        this.questionID = question.questionID;
        this.status = question.status;
        this.content = question.content;
        this.level = question.level;
        this.explanation = question.explanation;
    }
}

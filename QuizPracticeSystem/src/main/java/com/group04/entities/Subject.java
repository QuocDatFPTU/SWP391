/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.entities;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
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
@Table(name = "Subject")
public class Subject implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subjectID;

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
    private boolean status;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "updateDate")
    private Date updateDate;
    
    @NotBlank(message = "description can't be empty")
    @Size(max = 100, min = 5, message="description must have more than 5 characters")
    @Column(name = "description")
    private String description;
    
    @Column(name = "isActive")
    private boolean isActive;
    
    
    @OneToMany(mappedBy="subject", fetch = FetchType.LAZY)
    private Set<Dimension> dimension = new HashSet<>();
    
    @ManyToOne
    @JoinColumn(name="CourseID")
    private Course course;

    public Subject(Subject subject) {
        this.subjectID = subject.subjectID;
        this.subjectName = subject.subjectName;
        this.category = subject.category;
        this.owner = subject.owner;
        this.status = subject.status;
        this.updateDate = subject.updateDate;
        this.description = subject.description;
        this.isActive = subject.isActive;
    }
    
    
       
}

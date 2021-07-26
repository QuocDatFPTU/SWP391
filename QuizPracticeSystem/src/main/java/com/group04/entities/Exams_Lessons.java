/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ntdun
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Exams_Lessons")
public class Exams_Lessons implements Serializable {
    @Column(name = "examInfoID")
    private Long examInfoID;

    @Column(name = "lessonID")
    private Long lessonID;
}

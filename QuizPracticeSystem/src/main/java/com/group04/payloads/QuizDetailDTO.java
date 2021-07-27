/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.payloads;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Admin
 */
@Setter
@Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class QuizDetailDTO {
    private String quizName;
    private String subjectName;
    private String examLevel;
    private int duration;
    private float passRate;
    private String quizType;
    private String Description;
    private int numberOfQuestion;
    private String questionType;
    private ArrayList<GroupQuestionDTO> listGroupQuestion;
    private boolean isFillFull;

    public void setIsFillFull(boolean isFillFull) {
        this.isFillFull = isFillFull;
    }

    public boolean isIsFillFull() {
        return isFillFull;
    }
    
}

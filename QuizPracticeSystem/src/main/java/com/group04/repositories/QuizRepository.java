/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.repositories;

import com.group04.entities.Lesson;
import com.group04.entities.Question;
import java.util.List;

/**
 *
 * @author HP
 */
public interface QuizRepository {
    List<Question> getRandomQuestionByLessonID(Long lessonID);
    List<Lesson> getLessonBySubject(Long subjectID);
    List<Question> getQuestionsBySubject(Long subjectID);
    List<Question> getRandomQuestionsBySubject(Long subjectID,int n);
}

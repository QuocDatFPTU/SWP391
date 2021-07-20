/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.repositories;

import com.group04.entities.Question;
import java.util.List;

/**
 *
 * @author HP
 */
public interface QuestionRepository {
    List<Question> getQuestionByLessonId(Long questionId);
    public void deleteQuestion(Long questionId);
    public void updateQuestion(Question question);
    public void addQuestion(Question question);
    public static QuestionRepositoryImp createInstance(){
        return new QuestionRepositoryImp();
    }
}

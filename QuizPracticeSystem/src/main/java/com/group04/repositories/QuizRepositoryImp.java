/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.repositories;

import com.group04.entities.Course;
import com.group04.entities.Lesson;
import com.group04.entities.Question;
import com.group04.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author HP
 */
public class QuizRepositoryImp implements QuizRepository {

    @Override
    public List<Question> getRandomQuestionByLessonID(Long lessonID) {
        Transaction transaction = null;
        List<Question> listOfQuestion = null;
        int n = 0;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            listOfQuestion = session.createQuery("FROM Question Q WHERE Q.lessonID = :lessonID ORDER BY newid()").
                    setParameter("lessonID", lessonID).getResultList();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return listOfQuestion;
    }

    @Override
    public List<Lesson> getLessonBySubject(Long subjectID) {
        LessonRepository lessonRepo = new LessonRepositoryImp();
        List<Lesson> listOfLesson = lessonRepo.getLessonBySubjectId(subjectID);
        return listOfLesson;
    }

    @Override
    public List<Question> getQuestionsBySubject(Long subjectID) {
        List<Lesson> lessonList = getLessonBySubject(subjectID);
        List<Question> questions = new ArrayList<>();
        QuestionRepository questionRepo = QuestionRepository.createInstance();
        for (Lesson lesson : lessonList) {          
                questionRepo.getQuestionByLessonId(lesson.getLessonID()).forEach(question -> {
                    questions.add(question);
                });
            }
        return questions;
        }
    
    @Override
    public List<Question> getRandomQuestionsBySubject(Long subjectID, int n) {
        List<Question> questions = getQuestionsBySubject(subjectID);
        Collections.shuffle(questions);
        for(Question quest : questions){
            System.out.println(quest.toString());
        }
        return new ArrayList(questions.subList(0, n));
    }
    
}

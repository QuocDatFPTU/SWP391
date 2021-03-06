/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.repositories;

import com.group04.entities.Lesson;
import com.group04.entities.Question;
import com.group04.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author HP
 */
public class QuestionRepositoryImp implements QuestionRepository {

    @Override
    public List<Question> getQuestionByLessonId(Long lessonId) {
        Transaction transaction = null;
        List<Question> questions = null;
        Lesson lesson = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            //Lesson{
            //Question
            //}
            lesson = session.createQuery("FROM Lesson WHERE lessonID = :id",Lesson.class).setParameter("id", lessonId)
                    .getSingleResult();
            questions = new ArrayList<>(lesson.getQuestion());
            if (questions != null) {
                return questions;
            }
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                System.out.println("Loop Function in get Question");
                transaction.rollback();
            }
        }
        return null;
    }

    @Override
    public void deleteQuestion(Long questionId) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Question question = session.get(Question.class, questionId);
            if (question != null) {
                session.delete(question);
                System.out.println("question is deleted");
            }
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

        }
    }

    @Override
    public void updateQuestion(Question question) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(question);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void addQuestion(Question question) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(question);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    
}

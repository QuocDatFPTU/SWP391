/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.repositories;

import com.group04.entities.Lesson;
import com.group04.entities.Question;
import com.group04.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author HP
 */
public class QuestionRepositoryImp implements QuestionRepository {

    @Override
    public List<Question> getQuestionByLessonId(Long questionId) {
        Transaction transaction = null;
        List<Question> Question = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Question = session.createQuery("FROM Question WHERE lessonID = :id").setParameter("id", questionId)
                    .getResultList();
            if (Question != null) {
                return Question;
            }
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                System.out.println("Loop Function");
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
            session.evict(question);
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

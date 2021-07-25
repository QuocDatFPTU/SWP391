/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.repositories;

import com.group04.entities.Course;
import com.group04.entities.Lesson;
import com.group04.entities.Subject;
import com.group04.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author HP
 */
public class LessonRepositoryImp implements LessonRepository {

    @Override
    public List<Lesson> getLessonBySubjectId(Long subjectId) {
        Transaction transaction = null;
        List<Lesson> Lesson = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Lesson = session.createQuery("FROM Lesson WHERE subjectID = :id").setParameter("id", subjectId)
                    .getResultList();
            if (Lesson != null) {
                return Lesson;
            }
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                e.printStackTrace();
                System.err.println(e.getMessage());
                System.out.println("Loop Function");
                transaction.rollback();
            }
        }
        return null;
    }

    @Override
    public Lesson getLessonById(Long id) {
        Transaction transaction = null;
        Lesson lesson = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            lesson = (Lesson) session.createQuery("FROM Lesson L WHERE L.lessonID = :lessonID").setParameter("lessonID", id)
                    .getSingleResult();
            if (lesson != null) {
                return lesson;
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                System.out.println("Loop Function");
                e.printStackTrace();
                transaction.rollback();
            }         
        }
        return null;
    }

    @Override
    public void deleteLesson(Long lessonID) {
       Lesson lesson = this.getLessonById(lessonID);
       lesson.setActive(false);
       this.updateLesson(lesson);
       
    }

    @Override
    public void updateLesson(Lesson lesson) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.evict(lesson);
            session.merge(lesson);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void addLesson(Lesson lesson) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(lesson);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

}

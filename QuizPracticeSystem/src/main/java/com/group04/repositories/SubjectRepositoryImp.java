/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.repositories;

import com.group04.entities.Subject;
import com.group04.utiils.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ntdun
 */
public class SubjectRepositoryImp implements SubjectRepository {

    @Override
    public List<Subject> getAllSubject() {
        Transaction transaction = null;
        List <Subject> listOfSubject = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            listOfSubject = session.createQuery("from Subject").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return listOfSubject;
    }

    @Override
    public Subject getSubjectById(String subjectId) {
        Transaction transaction = null;
        Subject Subject = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Subject = (Subject) session.createQuery("FROM Subject S WHERE S.subjectID = :id").setParameter("id", subjectId)
                    .uniqueResult();
            if (Subject != null) {
                return Subject;
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                System.out.println("Loop Function");
                transaction.rollback();
            }
        }
        return null;
    }

    @Override
    public List<Subject> getSubjectByCourseId(String courseId) {
        Transaction transaction = null;
        List<Subject> Subject = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Subject = session.createQuery("FROM Subjec S WHERE S.courseID = :id").setParameter("id", courseId)
                    .getResultList();
            if (Subject != null) {
                return Subject;
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                System.out.println("Loop Function");
                transaction.rollback();
            }
        }
        return null;
    }

    
    
}

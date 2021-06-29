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
import org.hibernate.query.Query;

/**
 *
 * @author ntdun
 */
public class SubjectRepositoryImp implements SubjectRepository {
    
    @Override
    public List<Subject> getAllSubjectPaging(String courseID, int position, int pageSize) {
        Transaction transaction = null;
        Subject Subject = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Subject S WHERE S.courseID =: courseId").setParameter("courseId", courseID);
    query.setFirstResult(position);
    query.setMaxResults(pageSize);
        if(query.list() !=null){
            return query.list();
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.repositories;

import com.group04.entities.Dimension;
import com.group04.entities.Subject;
import com.group04.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author ntdun
 */
public class SubjectRepositoryImp implements SubjectRepository {

    @Override
    public List<Subject> getAllSubjectPaging(Long courseID, int position, int pageSize) {
        //Transaction transaction = null;
        Subject Subject = null;
         Session session = HibernateUtil.getSessionFactory().openSession();
        try {
           
           //transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Subject S WHERE S.course.courseID =:courseId").setParameter("courseId", courseID);
            query.setFirstResult(position);
            query.setMaxResults(pageSize);
            if (query.list() != null) {
                
                return query.list();
            }
          // transaction.commit();
            
        } catch (Exception e) {
            System.out.println(e);
//            if (transaction != null) {
//                System.out.println("Loop Function");
//                transaction.rollback();
//            }
        }finally{
            session.close();
        }
        return null;
    }

    @Override
    public Subject getSubjectById(Long subjectId) {
        Transaction transaction = null;
        Subject Subject = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            Subject = (Subject) session.createQuery("FROM Subject S WHERE S.subjectID = :id").setParameter("id", subjectId)
                    .uniqueResult();
            if (Subject != null) {
                return Subject;
            }
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                System.out.println("Loop Function");
                transaction.rollback();
            }
        }
        return null;
    }

    @Override
    public List<Subject> getSubjectByCourseId(Long courseId) {
        Transaction transaction = null;
        List<Subject> Subject = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Subject = session.createQuery("FROM Subject S WHERE S.courseID = :id").setParameter("id", courseId)
                    .getResultList();
            if (Subject != null) {
                return Subject;
            }
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                System.out.println("Loop Function");
                transaction.rollback();
            }
        }
        return null;
    }

    @Override
    public void deleteSubject(Long subjectID) {
        Subject subject = this.getSubjectById(subjectID);
        subject.setActive(false);
        this.updateSubject(subject);
    }

    @Override
    public void updateSubject(Subject subject) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(subject);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void addSubject(Subject subject) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(subject);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public List<String> getAllCategory() {
        Transaction transaction = null;
        List<String> category;
        category = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            category = session.createQuery("FROM Subject S WHERE S.category ")
                    .getResultList();
            if (category != null) {
                return category;
            }
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            if (transaction != null) {
                System.out.println("Loop Function");
                transaction.rollback();
            }
        }
        return null;
    }

    @Override
    public Subject getSubjectByName(String subjectName) {
        Transaction transaction = null;
        Subject Subject = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Subject = (Subject) session.createQuery("FROM Subject S WHERE S.subjectName = :name").setParameter("name", subjectName)
                    .uniqueResult();
            if (Subject != null) {
                return Subject;
            }
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                System.out.println("Loop Function");
                transaction.rollback();
            }
        }
        return null;
    }

    @Override
    public List<Subject> getAllSubject() {
        Transaction transaction = null;
        List<Subject> listOfSubject = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            listOfSubject = session.createQuery("from Subject").getResultList();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return listOfSubject;
    }

}

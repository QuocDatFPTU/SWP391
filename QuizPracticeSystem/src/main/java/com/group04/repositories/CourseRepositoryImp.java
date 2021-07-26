/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.repositories;

import com.group04.entities.Course;
import com.group04.utils.HibernateUtil;
import java.util.ArrayList;
import com.group04.utils.HibernateUtil;
import java.util.List;
import java.util.Random;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ntdun
 */
public class CourseRepositoryImp implements CourseRepository {

    @Override
    public  List<Course> getAllCourse() {
        Transaction transaction = null;
        List<Course> listOfCourse = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            listOfCourse = session.createQuery("from Course", Course.class).getResultList();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("loi excep :" +e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return listOfCourse;
    }

    @Override
    public void addCourse(Course course) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void updateCourse(Course course) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(course);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                e.printStackTrace();
                transaction.rollback();
            }
        }
    }

    @Override
    public void deleteCourse(Long courseID) {
        Course course = this.getCourse(courseID);
        course.setActive(false);
        this.updateCourse(course);
    }

    @Override
    public Course getCourse(Long courseID) {
        Transaction transaction = null;
        Course course = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            course = (Course) session.createQuery("FROM Course C WHERE C.courseID = :courseID").setParameter("courseID", courseID)
                    .getSingleResult();
            if (course != null) {
                return course;
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
    
    
}

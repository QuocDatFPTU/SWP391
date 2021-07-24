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
    public List<Course> getAllCourse() {
        Transaction transaction = null;
        List<Course> listOfCourse = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            listOfCourse = session.createQuery("from Course").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return listOfCourse;
    }

    @Override
    public void addCourse(Course course) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();
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
            session.evict(course);
            session.merge(course);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void deleteCourse(Long courseID) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Course course = session.get(Course.class, courseID);
            if (course != null) {
                session.delete(course);
                System.out.println("course is deleted");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

        }
    }

    @Override
    public Long getRandomID() {
        ArrayList<Long> listID = new ArrayList<>();
        Random rand = new Random();
        Long num;
        do {
            num = Long.valueOf(rand.nextInt(9000000) + 1000000);
        } while (!listID.contains(num));
        listID.add(num);
        return num;
    }

    @Override
    public Course getCourse(Long id) {
        Transaction transaction = null;
        Course course = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            course = (Course) session.createQuery("FROM Course C WHERE C.courseID = :id").setParameter("id", id)
                    .uniqueResult();
            if (course != null) {
                return course;
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

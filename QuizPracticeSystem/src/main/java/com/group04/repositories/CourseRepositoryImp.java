/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.repositories;

import com.group04.entities.Course;
import com.group04.utiils.HibernateUtil;
import java.util.List;
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
        List <Course> listOfCourse = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
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
    
}

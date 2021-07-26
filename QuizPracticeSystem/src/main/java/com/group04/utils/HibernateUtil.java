    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.utils;

import com.group04.entities.Blog;
import com.group04.entities.Course;
import com.group04.entities.Dimension;
import com.group04.entities.ExamDetail;
import com.group04.entities.ExamInfo;
import com.group04.entities.ExamSetting;
import com.group04.entities.Lesson;
import com.group04.entities.Option;
import com.group04.entities.OptionExam;
import com.group04.entities.Payment;
import com.group04.entities.Question;
import com.group04.entities.Role;
import com.group04.entities.Sale;
import com.group04.entities.StudentRegistration;
import com.group04.entities.Packages;
import com.group04.entities.QuestionExam;
import com.group04.entities.Subject;
import com.group04.entities.User;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author HP
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
                settings.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=QuizPractice");
                settings.put(Environment.USER, "sa");
                settings.put(Environment.PASS, "123456");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "none");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Role.class);
                configuration.addAnnotatedClass(StudentRegistration.class);
                configuration.addAnnotatedClass(Sale.class);
                configuration.addAnnotatedClass(Subject.class);
                configuration.addAnnotatedClass(Question.class);
                configuration.addAnnotatedClass(Payment.class);
                configuration.addAnnotatedClass(Packages.class);
                configuration.addAnnotatedClass(Option.class);
                configuration.addAnnotatedClass(Lesson.class);
                configuration.addAnnotatedClass(Dimension.class);
                configuration.addAnnotatedClass(Course.class);
                configuration.addAnnotatedClass(Blog.class);
                configuration.addAnnotatedClass(ExamInfo.class);
                configuration.addAnnotatedClass(ExamDetail.class);
                configuration.addAnnotatedClass(QuestionExam.class);
                configuration.addAnnotatedClass(OptionExam.class);
                configuration.addAnnotatedClass(ExamSetting.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                System.out.println("Hibernate Java Config serviceRegistry created");
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                return sessionFactory;
            } catch (Exception e) {
                System.out.println("Hibernate bugs: " + e);
            }
        }
        return sessionFactory;
    }
}

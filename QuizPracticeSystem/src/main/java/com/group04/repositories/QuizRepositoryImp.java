/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.repositories;

import com.group04.entities.Course;
import com.group04.entities.ExamInfo;
import com.group04.entities.Lesson;
import com.group04.entities.Question;
import com.group04.entities.QuestionExam;
import com.group04.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author HP
 */
public class QuizRepositoryImp implements QuizRepository {

    @Override
    public List<Question> getRandomQuestionByLessonID(Long lessonID) {
        Transaction transaction = null;
        List<Question> listOfQuestion = null;
        int n = 0;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            listOfQuestion = session.createQuery("FROM Question Q WHERE Q.lessonID = :lessonID ORDER BY newid()").
                    setParameter("lessonID", lessonID).getResultList();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return listOfQuestion;
    }

    @Override
    public List<Lesson> getLessonBySubject(Long subjectID) {
        LessonRepository lessonRepo = new LessonRepositoryImp();
        List<Lesson> listOfLesson = lessonRepo.getLessonBySubjectId(subjectID);
        return listOfLesson;
    }

    @Override
    public List<Question> getQuestionsBySubject(Long subjectID) {
        List<Lesson> lessonList = getLessonBySubject(subjectID);
        System.out.println("Done get Lesson by id");
        List<Question> quizzes = new ArrayList<>();
        QuestionRepository questionRepo = QuestionRepository.createInstance();
        for (Lesson lesson : lessonList) {
            questionRepo.getQuestionByLessonId(lesson.getLessonID()).forEach(question -> {
                quizzes.add(question);
            });
        }
        return quizzes;
    }

    @Override
    public List<Question> getRandomQuestionsBySubject(Long subjectID, int n) {
        List<Question> quizzes = getQuestionsBySubject(subjectID);
        System.out.println("Done");
        Collections.shuffle(quizzes);
        for (Question quest : quizzes) {
            System.out.println(quest.toString());
        }
        return new ArrayList(quizzes.subList(0, n));
    }

    @Override
    public List<ExamInfo> getAllExam() {
        Transaction transaction = null;
        List<ExamInfo> quizzes = null;
        
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            //Lesson{
            //Question
            //}
            quizzes = new ArrayList<ExamInfo>(session.createQuery("FROM ExamInfo", ExamInfo.class).getResultList());
            
            if (quizzes != null) {
                return quizzes;
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

}

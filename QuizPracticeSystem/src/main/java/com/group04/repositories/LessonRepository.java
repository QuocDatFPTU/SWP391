/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.repositories;

import com.group04.entities.Lesson;
import com.group04.entities.Subject;
import java.util.List;

/**
 *
 * @author HP
 */
public interface LessonRepository {

    List<Lesson> getLessonBySubjectId(Long subjectId);

    public Lesson getLessonById(Long lessonID);

    public void deleteLesson(Long lessonID);

    public void updateLesson(Lesson lesson);

    public void addLesson(Lesson lesson);
}

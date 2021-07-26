/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.repositories;

import com.group04.entities.Dimension;
import com.group04.entities.Lesson;
import com.group04.entities.Subject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ntdun
 */
public interface SubjectRepository {
   List<Subject> getAllSubjectPaging(Long courseID, int position, int pageSize);
   Subject getSubjectById(Long subjectId);
   List<Subject> getSubjectByCourseId(Long courseId);
   public void deleteSubject(Long subjectID);
   public void updateSubject(Subject subject);
   public void addSubject(Subject subject);
   List<String> getAllCategory();
   Subject getSubjectByName(String subjectName);
   List<Subject> getAllSubject();
   Subject getSubjectNameBySubjectID(String subjectID);
   List<Lesson> getLessonBySubjectId(Long subjectId);
}

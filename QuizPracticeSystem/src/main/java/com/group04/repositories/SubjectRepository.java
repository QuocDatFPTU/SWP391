/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.repositories;

import com.group04.entities.Subject;
import java.util.List;

/**
 *
 * @author ntdun
 */
public interface SubjectRepository {
   List<Subject> getAllSubjectPaging(String courseID, int position, int pageSize);
   Subject getSubjectById(String subjectId);
   List<Subject> getSubjectByCourseId(String courseId);
}

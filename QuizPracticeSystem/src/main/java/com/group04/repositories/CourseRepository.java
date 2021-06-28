/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.repositories;

import com.group04.entities.Course;
import java.util.List;

/**
 *
 * @author ntdun
 */
public interface CourseRepository {
    List<Course> getAllCourse();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.validators;

import com.group04.entities.Blog;
import com.group04.entities.Course;
import com.group04.entities.Dimension;
import com.group04.entities.Packages;
import com.group04.entities.Subject;
import com.group04.entities.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author HP
 */
public class DoValidate {
    public static List<String> validateU(User user){
        System.out.println("Dang check loi ");
        List<String> errors = new ArrayList<>();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<User>> cvs = validator.validate(user);
        System.out.println("Loi: "+cvs.size());
        if(!cvs.isEmpty()){
            for (ConstraintViolation<User> cv : cvs) {
                StringBuilder err = new StringBuilder();
                err.append(cv.getPropertyPath());
                err.append(" ");
                err.append(cv.getMessage());
                errors.add(err.toString());
            }
        }
        return errors;
    }
    public static List<String> validateC(Course course){
        System.out.println("Dang check loi ");
        List<String> errors = new ArrayList<>();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Course>> cvs = validator.validate(course);
        System.out.println("Loi: "+cvs.size());
        if(!cvs.isEmpty()){
            for (ConstraintViolation<Course> cv : cvs) {
                StringBuilder err = new StringBuilder();
                err.append(cv.getPropertyPath());
                err.append(" ");
                err.append(cv.getMessage());
                errors.add(err.toString());
            }
        }
        return errors;
    }
    public static List<String> validateS(Subject subject){
        System.out.println("Dang check loi ");
        List<String> errors = new ArrayList<>();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Subject>> cvs = validator.validate(subject);
        System.out.println("Loi: "+cvs.size());
        if(!cvs.isEmpty()){
            for (ConstraintViolation<Subject> cv : cvs) {
                StringBuilder err = new StringBuilder();
                err.append(cv.getPropertyPath());
                err.append(" ");
                err.append(cv.getMessage());
                errors.add(err.toString());
            }
        }
        return errors;
    }
    
    public static List<String> validateB(Blog blog){
        System.out.println("Dang check loi ");
        List<String> errors = new ArrayList<>();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Blog>> cvs = validator.validate(blog);
        System.out.println("Loi: "+cvs.size());
        if(!cvs.isEmpty()){
            for (ConstraintViolation<Blog> cv : cvs) {
                StringBuilder err = new StringBuilder();
                err.append(cv.getPropertyPath());
                err.append(" ");
                err.append(cv.getMessage());
                errors.add(err.toString());
            }
        }
        return errors;
    }
   
    public static List<String> validateP(Packages packages){
        System.out.println("Dang check loi ");
        List<String> errors = new ArrayList<>();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Packages>> cvs = validator.validate(packages);
        System.out.println("Loi: "+cvs.size());
        if(!cvs.isEmpty()){
            for (ConstraintViolation<Packages> cv : cvs) {
                StringBuilder err = new StringBuilder();
                err.append(cv.getPropertyPath());
                err.append(" ");
                err.append(cv.getMessage());
                errors.add(err.toString());
            }
        }
        return errors;
    }
    
    public static List<String> validateD(Dimension dimension){
        System.out.println("Dang check loi ");
        List<String> errors = new ArrayList<>();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Dimension>> cvs = validator.validate(dimension);
        System.out.println("Loi: "+cvs.size());
        if(!cvs.isEmpty()){
            for (ConstraintViolation<Dimension> cv : cvs) {
                StringBuilder err = new StringBuilder();
                err.append(cv.getPropertyPath());
                err.append(" ");
                err.append(cv.getMessage());
                errors.add(err.toString());
            }
        }
        return errors;
    }
}

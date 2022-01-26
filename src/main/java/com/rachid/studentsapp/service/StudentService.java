package com.rachid.studentsapp.service;

import com.rachid.studentsapp.entity.StudentEntity;

import java.util.List;

public interface StudentService {
    StudentEntity addStudent(StudentEntity student);

    StudentEntity getStudentById(Integer id);

    List<StudentEntity> getAllStudent();

    StudentEntity deleteStudentById(Integer id);


    StudentEntity updateStudent(StudentEntity studentEntity, Integer id);

    StudentEntity getStudentByName(String name);
}

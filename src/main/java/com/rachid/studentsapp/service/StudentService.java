package com.rachid.studentsapp.service;

import com.rachid.studentsapp.entity.StudentEntity;

import java.util.List;

public interface StudentService {
    StudentEntity addStudent(StudentEntity student);

    StudentEntity getStudentById(Integer id);

    List<StudentEntity> getAllStudent();
}

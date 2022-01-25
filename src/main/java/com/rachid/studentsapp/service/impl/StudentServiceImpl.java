package com.rachid.studentsapp.service.impl;

import com.rachid.studentsapp.entity.StudentEntity;
import com.rachid.studentsapp.repository.StudentRepository;
import com.rachid.studentsapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentEntity addStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    @Override
    public StudentEntity getStudentById(Integer id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<StudentEntity> getAllStudent() {
        return studentRepository.findAll();
    }

}

package com.rachid.studentsapp.service.impl;

import com.rachid.studentsapp.entity.StudentEntity;
import com.rachid.studentsapp.exception.StudentNotFoundException;
import com.rachid.studentsapp.repository.StudentRepository;
import com.rachid.studentsapp.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<StudentEntity> studentEntity = studentRepository.findById(id);
        if(!studentEntity.isPresent())
            throw new StudentNotFoundException("student with id: "+ id + " does not exist in database.");

        return studentEntity.get();
    }

    @Override
    public List<StudentEntity> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public StudentEntity deleteStudentById(Integer id) {
         studentRepository.deleteById(id);
         return null;
    }

    @Override
    public StudentEntity updateStudent(StudentEntity studentEntity, Integer id) {
        StudentEntity student = studentRepository.findById(id).get();
        if(StringUtils.isNotEmpty(studentEntity.getName())){
            student.setName(studentEntity.getName());
        }
        if(StringUtils.isNotEmpty(studentEntity.getAddress())){
            student.setAddress(studentEntity.getAddress());
        }
        if(StringUtils.isNotEmpty(studentEntity.getRollNo())){
            student.setRollNo(studentEntity.getRollNo());
        }
        return studentRepository.save(student);
    }

    @Override
    public StudentEntity getStudentByName(String name) {
        return studentRepository.findByName(name);
    }


}

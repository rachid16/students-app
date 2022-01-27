package com.rachid.studentsapp.service.impl;

import com.rachid.studentsapp.entity.StudentEntity;
import com.rachid.studentsapp.repository.StudentRepository;
import com.rachid.studentsapp.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class StudentServiceImplTest {

    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;


    @BeforeEach
    void setup(){
        Optional<StudentEntity>  optionalStudentEntity =
                Optional.of(new StudentEntity(1, "testName", "101", "Atl"));
        Mockito.when( studentRepository.findById(1)).thenReturn(optionalStudentEntity);
    }

    @Test
    void getStudentById() {
        String name = "testName";
        StudentEntity studentById = studentService.getStudentById(1);
        assertEquals("testName", studentById.getName());
    }
}
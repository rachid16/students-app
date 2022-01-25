package com.rachid.studentsapp.controller;

import com.rachid.studentsapp.entity.StudentEntity;
import com.rachid.studentsapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/")
    public StudentEntity addStudent(@RequestBody StudentEntity student){
        return studentService.addStudent(student);
    }

    @GetMapping("/{student-id}")
    public StudentEntity getStudentById(@PathVariable("student-id") Integer id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/")
    public List<StudentEntity> getAllStudent(){
        return studentService.getAllStudent();
    }
}

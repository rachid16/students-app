package com.rachid.studentsapp.controller;

import com.rachid.studentsapp.entity.StudentEntity;
import com.rachid.studentsapp.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
@Validated
public class StudentController {

    private final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @PostMapping("/")
    public StudentEntity addStudent(@Valid  @RequestBody StudentEntity student, BindingResult result){
        LOGGER.info("Inside StudentController addStudent method. student {}", student);
        List<ObjectError> allErrors = result.getAllErrors();
        for(ObjectError error : allErrors)
            LOGGER.info("error >> : {}", error);

        return studentService.addStudent(student);
    }

    @GetMapping("/{student-id}")
    public StudentEntity getStudentById( @PathVariable("student-id") Integer id){
        LOGGER.info("Inside StudentController getStudentById method. student id: {}", id);
        return studentService.getStudentById(id);
    }

    @GetMapping("/name/{student-name}")
    public StudentEntity getStudentByName(@PathVariable("student-name") String name){
        LOGGER.info("Inside StudentController getStudentByName method. student name: {}", name);
        return studentService.getStudentByName(name);
    }

    @GetMapping("/")
    public List<StudentEntity> getAllStudent(){
        LOGGER.info("Inside StudentController getAllStudent method. {}");
        return studentService.getAllStudent();
    }

    @DeleteMapping ("/{student-id}")
    public StudentEntity deleteStudentById(@PathVariable("student-id") Integer id){
        LOGGER.info("Inside StudentController deleteStudentById method. student id: {}", id);
        return studentService.deleteStudentById(id);
    }

    @PutMapping("/{student-id}")
    public StudentEntity updateStudent(@PathVariable("student-id") Integer id, @RequestBody StudentEntity studentEntity){
        LOGGER.info("Inside StudentController updateStudent method. student id: {}", id);
        return studentService.updateStudent(studentEntity, id);
    }

}

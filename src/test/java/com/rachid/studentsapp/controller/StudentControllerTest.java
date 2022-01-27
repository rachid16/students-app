package com.rachid.studentsapp.controller;

import com.rachid.studentsapp.entity.StudentEntity;
import com.rachid.studentsapp.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    private StudentEntity studentEntity;

    @BeforeEach
    void setup(){
       studentEntity = new StudentEntity(1, "testName", "101", "Atl");
        Mockito.when(studentService.addStudent(studentEntity)).thenReturn(studentEntity);
    }

    @Test
    public void testAddStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/student/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\r\n" +
                        "  \"id\": 1,\r\n" +
                        "  \"name\": \"testName\",\r\n" +
                        "  \"rollNo\": 101,\r\n" +
                        "  \"address\": \"Atl\"\r\n" +
                        "}"))

                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
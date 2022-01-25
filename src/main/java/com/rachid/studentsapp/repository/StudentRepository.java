package com.rachid.studentsapp.repository;

import com.rachid.studentsapp.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
}

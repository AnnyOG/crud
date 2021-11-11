package com.example.crud_jpa.service;

import com.example.crud_jpa.model.Student;

import java.util.List;

public interface StudentToTeacherService {
    void createRelation(Long student_id, Long teacher_id);
    void deleteRelation(Long student_id, Long teacher_id);
    List<Student> getStudents(Long id);
}

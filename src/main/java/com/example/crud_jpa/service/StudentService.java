package com.example.crud_jpa.service;

import com.example.crud_jpa.model.Student;

import java.util.Optional;

public interface StudentService {
    void insertStudent (Student student);
    void updateStudent(Student student);
    void deleteStudentById (Long id);
    Iterable<Student> getAllStudent();
    Optional<Student> findStudentById(Long id);
}

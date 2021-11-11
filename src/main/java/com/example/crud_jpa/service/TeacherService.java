package com.example.crud_jpa.service;

import com.example.crud_jpa.model.Teacher;

import java.util.Optional;

public interface TeacherService {
    void insertTeacher (Teacher teacher);
    void updateTeacher(Teacher teacher);
    void deleteTeacherById (Long id);
    Iterable<Teacher> getAllTeacher();
    Optional<Teacher> findTeacherById(Long id);
}

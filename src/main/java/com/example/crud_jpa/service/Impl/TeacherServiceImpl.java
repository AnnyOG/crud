package com.example.crud_jpa.service.Impl;

import com.example.crud_jpa.model.Teacher;
import com.example.crud_jpa.repository.TeacherRepo;
import com.example.crud_jpa.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private final TeacherRepo teacherRepo;

    public TeacherServiceImpl(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    @Override
    public void insertTeacher(Teacher teacher) {
        teacherRepo.save(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherRepo.save(teacher);
    }

    @Override
    public void deleteTeacherById(Long id) {
        teacherRepo.deleteById(id);
    }

    @Override
    public Iterable<Teacher> getAllTeacher() {
        return teacherRepo.findAll();
    }

    @Override
    public Optional<Teacher> findTeacherById(Long id) {
        return teacherRepo.findById(id);
    }
}

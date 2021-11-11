package com.example.crud_jpa.service.Impl;

import com.example.crud_jpa.model.Student;
import com.example.crud_jpa.model.Teacher;
import com.example.crud_jpa.repository.StudentRepo;
import com.example.crud_jpa.repository.StudentToTeacherRepo;
import com.example.crud_jpa.repository.TeacherRepo;
import com.example.crud_jpa.service.StudentToTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentToTeacherServiceImpl implements StudentToTeacherService {
    @Autowired
    private TeacherRepo teacherRepo;
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private StudentToTeacherRepo studentToTeacherRepo;

    @Override
    public void createRelation(Long student_id, Long teacher_id) {
        Student student = studentRepo.findById(student_id).get();
        Teacher teacher = teacherRepo.findById(teacher_id).get();
        teacher.getStudents().add(student);
        student.getTeachers().add(teacher);

    }

    @Override
    public void deleteRelation(Long student_id, Long teacher_id) {
        Student student = studentRepo.findById(student_id).get();
        Teacher teacher = teacherRepo.findById(teacher_id).get();
        teacher.getStudents().remove(student);
        student.getTeachers().remove(teacher);
    }

    @Override
    public List<Student> getStudents(Long id) {
        return studentToTeacherRepo.findByTeacher_id(id);
    }
}

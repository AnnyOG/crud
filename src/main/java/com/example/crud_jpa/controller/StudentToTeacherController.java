package com.example.crud_jpa.controller;

import com.example.crud_jpa.model.Student;
import com.example.crud_jpa.repository.StudentToTeacherRepo;
import com.example.crud_jpa.service.CommandService;
import com.example.crud_jpa.service.StudentService;
import com.example.crud_jpa.service.StudentToTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentToTeacherController {
    @Autowired
    private StudentToTeacherService service;
    @Autowired
    private CommandService commandService;


    @PostMapping("/")
    public ResponseEntity<String> addRelation(@RequestParam(value = "teacher_id") Long teacher_id,
                                                        @RequestParam(value = "student_id") Long student_id)
    {
        service.createRelation(student_id, teacher_id);
        commandService.commandNotify("Добавлена связь");
        return ResponseEntity.ok("Добавлена связь");
    }

    @DeleteMapping ("/")
    public ResponseEntity<String> deleteRelation(@RequestParam(value = "teacher_id") Long teacher_id,
                                             @RequestParam(value = "student_id") Long student_id)
    {
        service.deleteRelation(student_id, teacher_id);
        commandService.commandNotify("Удалена связь");
        return ResponseEntity.ok("Удалена связь");
    }

    @GetMapping ("/")
    public ResponseEntity<List<Student>> getStudents(@RequestParam(value = "teacher_id") Long teacher_id)
    {
        List<Student> students = service.getStudents(teacher_id);
        commandService.commandNotify("Найдены студенты");
       return ResponseEntity.ok(students);
    }
}

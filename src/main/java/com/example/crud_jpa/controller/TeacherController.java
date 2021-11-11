package com.example.crud_jpa.controller;

import com.example.crud_jpa.model.Student;
import com.example.crud_jpa.model.Teacher;
import com.example.crud_jpa.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teachers/{id}")
    public ResponseEntity<Optional<Teacher>> getTeacher(@PathVariable(value = "id") Long id)
    {
        if(id ==  null) return ResponseEntity.badRequest().body(null);
        return ResponseEntity.ok(teacherService.findTeacherById(id));
    }

    @PostMapping("/teachers/")
    public ResponseEntity<String> saveTeacher(@RequestBody Teacher teacher)
    {
        if(teacher ==  null) return ResponseEntity.badRequest().body("Неверный формат данных");
        teacherService.insertTeacher(teacher);
        return ResponseEntity.ok("Преподаватель добавлен");
    }

    @PutMapping ("/teachers/")
    public ResponseEntity<String> updateTeacher(@RequestBody Teacher teacher)
    {
        if(teacher ==  null) return ResponseEntity.badRequest().body("Неверный формат данных");
        teacherService.updateTeacher(teacher);
        return ResponseEntity.ok("Преподаватель изменен");
    }

    @DeleteMapping ("/teachers/{id}")
    public  ResponseEntity<String> deleteTeacher(@PathVariable(value = "id") Long id)
    {
        if(id ==  null) return ResponseEntity.badRequest().body("Неверный формат данных");
        teacherService.deleteTeacherById(id);
        return ResponseEntity.ok("Преподаватель удален");
    }

    @GetMapping("/teachers/")
    public ResponseEntity<Iterable<Teacher>> getTeacher()
    {
        Iterable<Teacher> allTeacher = teacherService.getAllTeacher();
        return ResponseEntity.ok(allTeacher);
    }
}

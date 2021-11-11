package com.example.crud_jpa.controller;

import com.example.crud_jpa.model.Student;
import com.example.crud_jpa.service.CommandService;
import com.example.crud_jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CommandService commandService;

    /**
     * Поиск студента по id
     * */
    @GetMapping("/students/{id}")
    public ResponseEntity<Optional<Student>> getStudent(@PathVariable(value = "id") Long id)
    {
        if(id ==  null) return ResponseEntity.badRequest().body(null);
        commandService.commandNotify("Найден студент с id " + id);
        return ResponseEntity.ok(studentService.findStudentById(id));
    }

    /**
     * Добавление студента
     * */
    @PostMapping("/students/")
    public ResponseEntity<String> saveStudent(@RequestBody Student student)
    {
        if(student ==  null) return ResponseEntity.badRequest().body("Неверный формат");
        studentService.insertStudent(student);
        commandService.commandNotify("Студент добавлен");
        return ResponseEntity.ok("Студен добавлен");
    }

    /**
     * Изменение студента
     * */
    @PutMapping ("/students/")
    public ResponseEntity<String> updateStudent(@RequestBody Student student)
    {
        if(student ==  null) return ResponseEntity.badRequest().body("Неверный формат");
        studentService.updateStudent(student);
        commandService.commandNotify("Студент изменен");
        return ResponseEntity.ok("Студен изменен");
    }

    /**
     * Удаление студента по id
     * */
    @DeleteMapping ("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable(value = "id") Long id)
    {
        if(id ==  null) return ResponseEntity.badRequest().body("Неверный формат");
        studentService.deleteStudentById(id);
        commandService.commandNotify("Студент с id " + id + "удален");
        return ResponseEntity.ok("Студен удален");
    }

    /**
     * Поиск всех студентов
     * */
    @GetMapping("/students/")
    public ResponseEntity<Iterable<Student>> getCarDetails()
    {
        Iterable<Student> allStudent = studentService.getAllStudent();
        commandService.commandNotify("Студенты найдены");
        return ResponseEntity.ok(allStudent);
    }
}

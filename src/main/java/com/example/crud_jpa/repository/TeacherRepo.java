package com.example.crud_jpa.repository;

import com.example.crud_jpa.model.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepo extends CrudRepository<Teacher, Long> {
}

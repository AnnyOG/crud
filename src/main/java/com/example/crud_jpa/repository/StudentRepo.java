package com.example.crud_jpa.repository;

import com.example.crud_jpa.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student, Long> {
}

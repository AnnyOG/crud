package com.example.crud_jpa.repository;

import com.example.crud_jpa.model.Student;
import com.example.crud_jpa.model.Teacher;
import jdk.jfr.EventSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentToTeacherRepo extends CrudRepository<Student, Long> {

    @Query("select s.id from Student s join s.teachers t where t.id = :id")
    List<Student> findByTeacher_id(@Param("id")Long id);
}

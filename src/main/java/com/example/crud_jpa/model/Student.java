package com.example.crud_jpa.model;


import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * ФИО
     * */
    @Column(name = "fio")
    private String fio;

    /**
     * Специальность
     * */
    @Column(name = "speciality")
    private String speciality;

    /**
     * Курс
     * */
    @Column(name = "course")
    private int course;

    @ManyToMany
    @JoinTable(name="student_teacher",joinColumns = @JoinColumn(name ="student_id"),inverseJoinColumns = @JoinColumn(name="teacher_id"))
    private Set<Teacher> teachers;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}

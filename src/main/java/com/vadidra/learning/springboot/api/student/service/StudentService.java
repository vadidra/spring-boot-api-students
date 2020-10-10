package com.vadidra.learning.springboot.api.student.service;

import com.vadidra.learning.springboot.api.student.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> listStudents();
    Student findStudent(long id);
}
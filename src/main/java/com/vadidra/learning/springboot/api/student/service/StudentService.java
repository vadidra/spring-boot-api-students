package com.vadidra.learning.springboot.api.student.service;

import com.vadidra.learning.springboot.api.student.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> selectAllStudents();
    Student selectStudentById(long id);
    void insertNewStudent(Student student);
    void updateStudent(Student newStudent);
    void deleteStudentById(long id);
    long countStudents();
}
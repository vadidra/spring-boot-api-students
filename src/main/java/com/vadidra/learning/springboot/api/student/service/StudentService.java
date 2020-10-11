package com.vadidra.learning.springboot.api.student.service;

import com.vadidra.learning.springboot.api.student.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> selectAllStudents();
    Student selectStudentById(long id);
    int insertNewStudent(Student student);
    int updateStudent(Student newStudent);
    int deleteStudentById(long id);
    long countStudents();
}
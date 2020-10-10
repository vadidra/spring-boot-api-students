package com.vadidra.learning.springboot.api.student.service;

import com.vadidra.learning.springboot.api.student.entity.Student;
import com.vadidra.learning.springboot.api.student.exception.StudentNotFoundException;
import com.vadidra.learning.springboot.api.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> listStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student findStudent(long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if(optionalStudent.isPresent())
            return optionalStudent.get();
        else
            throw new StudentNotFoundException("Student Not Found");
    }

}
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
    public List<Student> selectAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student selectStudentById(long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if(optionalStudent.isPresent())
            return optionalStudent.get();
        else
            throw new StudentNotFoundException("Student Not Found");
    }

    @Override
    public int insertNewStudent(Student student){
        studentRepository.save(student);
        return 1;
    }

    @Override
    public int deleteStudentById(long id) {

        if(studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return 1;
        }
        else
            throw new StudentNotFoundException("Student Not Found");
    }

    @Override
    public int updateStudent(Student newStudent) {

        if(studentRepository.existsById(newStudent.getId()))
        {
            studentRepository.deleteById(newStudent.getId());
            studentRepository.save(newStudent);
            return 1;
        }
        else
            throw new StudentNotFoundException("Student Not Found");
    }

    @Override
    public long countStudents() { return studentRepository.count(); }

}
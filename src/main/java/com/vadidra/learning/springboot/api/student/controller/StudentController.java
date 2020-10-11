package com.vadidra.learning.springboot.api.student.controller;

import com.vadidra.learning.springboot.api.student.entity.Student;
import com.vadidra.learning.springboot.api.student.exception.StudentNotFoundException;
import com.vadidra.learning.springboot.api.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> list = studentService.selectAllStudents();
        return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") long id) {
        try {
            return new ResponseEntity<Student>(studentService.selectStudentById(id), HttpStatus.OK);
        } catch (StudentNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student Not Found");
        }
    }

    @GetMapping("/students/total")
    public ResponseEntity<Long> getTotal() {
        Long total = studentService.countStudents();
        return new ResponseEntity<Long>(total, HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<Integer> insertNewStudent(@RequestBody Student student){
        try {
            return new ResponseEntity<Integer>(Integer.valueOf(studentService.insertNewStudent(student)), HttpStatus.OK);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request");
        }
    }

    @RequestMapping(
        method = RequestMethod.PUT,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void updateStudent(
        @RequestBody Student student){
        studentService.updateStudent(student);
    }


    @DeleteMapping("/students/{id}")
    public ResponseEntity<Integer> deleteStudent(@PathVariable long id) {
        try {
            return new ResponseEntity<Integer>(Integer.valueOf(studentService.deleteStudentById(id)), HttpStatus.OK);
        } catch (StudentNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student Not Found");
        }
    }

}
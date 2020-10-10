package com.vadidra.learning.springboot.api.student.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String exception) {
        super(exception);
    }
}

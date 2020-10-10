package com.vadidra.learning.springboot.api.student.repository;

import com.vadidra.learning.springboot.api.student.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
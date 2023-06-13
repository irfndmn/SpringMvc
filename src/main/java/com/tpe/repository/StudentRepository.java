package com.tpe.repository;

import com.tpe.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    void save(Student student);
    void delete(Long id);
    Optional<Student> findById(Long id);
    List<Student> findAll();
}
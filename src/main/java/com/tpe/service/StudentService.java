package com.tpe.service;

import com.tpe.domain.Student;
import java.util.List;

public interface StudentService {
    void saveStudent(Student student);
    void deleteStudent(Long id);
    Student getStudentById(Long id);
    List<Student> getAllStudent();
}

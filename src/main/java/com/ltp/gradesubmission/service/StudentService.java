package com.ltp.gradesubmission.service;

import java.util.List;

import com.ltp.gradesubmission.entity.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    Student getStudent(Long id);
    Student saveStudent(Student student);
    void deleteStudent(Long id);
    List<Student> getStudents();
    Boolean isPresentStudent(Long id);
    Student updateStudent(Student student, Long id);
}
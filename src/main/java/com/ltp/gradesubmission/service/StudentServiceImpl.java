package com.ltp.gradesubmission.service;

import java.util.List;
import java.util.Optional;

import com.ltp.gradesubmission.entity.Grade;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.exception.StudentNotFoundException;
import com.ltp.gradesubmission.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StudentServiceImpl implements StudentService {
//bisa menggunakan autowired/ menggunakan method dari lombok allArgConstructor, but the autowired must be deleted
    @Autowired
    StudentRepository studentRepository;
    @Override
    public Student getStudent(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()){
            printGarden(optionalStudent.get());
            return optionalStudent.get();
        }else {
            throw new StudentNotFoundException(id);
        }
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()){
            studentRepository.deleteById(id);
        }else {
            throw new StudentNotFoundException(id);
        }
    }

    @Override
    public List<Student> getStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Boolean isPresentStudent(Long id) {
        return studentRepository.existsById(id);
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        return studentRepository.save(student);
    }

    void printGarden(Student student){
        for(Grade grade: student.getGrades()){
            System.out.println(grade.getScore());
        }
    }

}
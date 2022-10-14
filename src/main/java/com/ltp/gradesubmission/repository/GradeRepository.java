package com.ltp.gradesubmission.repository;

import com.ltp.gradesubmission.entity.Grade;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GradeRepository extends CrudRepository<Grade, Long> {
    List<Grade> findByStudentId(Long studentId);
    Optional<Grade> findByStudentIdAndCourseId(Long studentId, Long courseId);
    List<Grade> findByCourseId(Long courseId);

}
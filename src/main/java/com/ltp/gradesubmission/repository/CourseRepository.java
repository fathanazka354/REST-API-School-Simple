package com.ltp.gradesubmission.repository;

import com.ltp.gradesubmission.entity.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
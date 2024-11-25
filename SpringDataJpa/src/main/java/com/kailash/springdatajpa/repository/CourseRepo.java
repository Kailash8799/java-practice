package com.kailash.springdatajpa.repository;

import com.kailash.springdatajpa.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {}

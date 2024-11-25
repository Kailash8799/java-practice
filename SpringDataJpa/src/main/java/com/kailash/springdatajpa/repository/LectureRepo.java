package com.kailash.springdatajpa.repository;

import com.kailash.springdatajpa.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepo extends JpaRepository<Lecture, Integer> {}

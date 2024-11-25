package com.kailash.springdatajpa.repository;

import com.kailash.springdatajpa.model.Auther;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutherRepo extends JpaRepository<Auther, Integer> {}

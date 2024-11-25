package com.kailash.springdatajpa.repository;

import com.kailash.springdatajpa.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepo extends JpaRepository<Section, Integer> {}

package com.kailash.springdatajpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Resources {

  @Id
  @GeneratedValue
  private Integer id;

  // @OneToOne(mappedBy = "resources")
  @OneToOne
  @JoinColumn(name = "lecture_id")
  private Lecture lecture;
}

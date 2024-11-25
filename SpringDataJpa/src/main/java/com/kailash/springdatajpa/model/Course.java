package com.kailash.springdatajpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Course extends BaseEntity {

  private String title;
  private String description;

  @ManyToMany
  @JoinTable(
    name = "auther_courses",
    joinColumns = { @JoinColumn(name = "course_id") },
    inverseJoinColumns = { @JoinColumn(name = "auther_id") }
  )
  private List<Auther> authers;

  @OneToMany(mappedBy = "course")
  private List<Section> sections;
}

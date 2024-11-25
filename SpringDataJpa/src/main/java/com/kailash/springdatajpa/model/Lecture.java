package com.kailash.springdatajpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
public class Lecture extends BaseEntity {

  private String name;

  @ManyToOne
  @JoinColumn(name = "section_id")
  private Section section;

  @OneToOne
  @JoinColumn(name = "resources_id")
  private Resources resources;
}

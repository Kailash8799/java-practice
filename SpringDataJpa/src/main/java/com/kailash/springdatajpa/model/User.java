package com.kailash.springdatajpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue
  // @GeneratedValue(
  //   strategy = GenerationType.SEQUENCE,
  //   generator = "SEQUENCE_GEN"
  // )
  // @SequenceGenerator(
  //   name = "SEQUENCE_GEN",
  //   allocationSize = 1,
  //   initialValue = 1,
  //   sequenceName = "SEQUENCE_GEN"
  // )

  // @GeneratedValue(strategy = GenerationType.TABLE, generator = "hey")
  // @TableGenerator(
  //   allocationSize = 1,
  //   initialValue = 1,
  //   name = "hey",
  //   pkColumnName = "id_name",
  //   valueColumnName = "id_value",
  //   table = "id_gen"
  // )
  private Integer id;

  private String username;
}

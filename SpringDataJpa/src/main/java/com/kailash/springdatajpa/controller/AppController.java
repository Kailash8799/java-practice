package com.kailash.springdatajpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

  @GetMapping("/")
  public String getMethodName() {
    return "Hello";
  }

  @PostMapping("/create")
  public String create() {
    return "Welcome to Spring Data JPA";
  }

  @PutMapping("/{id}")
  public String putMethodName(
    @PathVariable String id,
    @RequestBody String entity
  ) {
    return entity;
  }

  @PatchMapping("/patch/{id}")
  public String patchMappring(@PathVariable String id) {
    return "";
  }
}

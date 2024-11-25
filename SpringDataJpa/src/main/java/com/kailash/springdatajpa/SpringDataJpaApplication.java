package com.kailash.springdatajpa;

import com.kailash.springdatajpa.model.Auther;
import com.kailash.springdatajpa.model.Course;
import com.kailash.springdatajpa.repository.AutherRepo;
import com.kailash.springdatajpa.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

  @Autowired
  private AutherRepo autherRepo;

  @Autowired
  private CourseRepo courseRepo;

  public static void main(String[] args) {
    SpringApplication.run(SpringDataJpaApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Auther auth = Auther
      .builder()
      .email("kailash@fmmail.com")
      .firstName("kailash")
      .lastName("rajput")
      .build();
    Course cs = Course.builder().title("Hey").description("ohh").build();
    // auth = autherRepo.save(auth);
    // cs = courseRepo.save(cs);

    // auth.setCourses(List.of(cs));
    // cs.setAuthers(List.of(auth));

    // autherRepo.save(auth);
    // courseRepo.save(cs);
  }
}

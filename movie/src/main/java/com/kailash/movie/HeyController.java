package com.kailash.movie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeyController {

  @GetMapping("/")
  public String sayHey() {
    System.out.println("Hey there!");
    return "Hey there!";
  }
  @PostMapping("/hey")
  public String sayposHey() {
    System.out.println("Hey there!");
    return "Hey there!";
  }
}

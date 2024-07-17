package com.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {

  @GetMapping("/home")
  public String home(Model model) {
    model.addAttribute("message", "Welcome to the home page!");
    return "index";
  }
}

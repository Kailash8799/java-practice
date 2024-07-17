package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

  private static ApplicationContext context;

  public static void main(String[] args) {
    // context = new ClassPathXmlApplicationContext("applicationContext.xml");
    context = new AnnotationConfigApplicationContext(Config.class);
    User user = context.getBean(User.class);
    user.getConnection();
    user.createTable();
    user.insertData("kailash");
  }
}

package com.example;

import com.example.config.AppConfig;
import com.example.dao.UserDao;
import com.example.models.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
      AppConfig.class
    );
    UserDao userDao = context.getBean("userDao", UserDao.class);

    User user = new User();
    user.setName("User");
    user.setEmail("user@example.com");
    user.setPassword("password");

    userDao.save(user);

    context.close();
  }
}

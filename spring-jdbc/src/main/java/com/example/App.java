package com.example;

import com.example.dao.interfaces.IUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(
      Config.class
    );
    IUser userDao = context.getBean("userDao", IUser.class);
    userDao.createTable();
    userDao.insertUser("John", "kailash@fmai.com", "1234");
    userDao.getAllUsers();
  }
}

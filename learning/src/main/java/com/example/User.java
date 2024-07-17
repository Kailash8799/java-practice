package com.example;

import java.sql.Connection;
import java.sql.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {

  @Autowired
  private DbContext dbContext;

  public User() {
    System.out.println("User constructor");
  }

  public void getConnection() {
    Connection connection = dbContext.getConnection();
    System.out.println(connection);
  }

  public void createTable() {
    Connection connection = dbContext.getConnection();
    String sql =
      "CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY, name VARCHAR(255))";
    try {
      connection.createStatement().execute(sql);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void insertData(String name) {
    Connection connection = dbContext.getConnection();
    String sql = "INSERT INTO users (id, name) VALUES (3,'kaadd')";
    try {
      Statement statement = connection.createStatement();
      statement.executeUpdate(sql);
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

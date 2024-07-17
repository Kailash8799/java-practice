package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
// import java.util.Properties;
import org.springframework.stereotype.Component;

@Component
public class DbContext {

  // private Properties properties;
  private Connection connection;

  public DbContext() {
    System.out.println("DbContext constructor");
  }

  public Connection getConnection() {
    try {
      DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
      connection =
        DriverManager.getConnection(
          "jdbc:mysql://localhost:3307/spring?createDatabaseIfNotExist=true",
          "root",
          "root"
        );
    } catch (Exception e) {
      System.out.println(e);
    }
    return connection;
  }
  // public void setProperties(Properties properties) {
  //   this.properties = properties;
  // }
}

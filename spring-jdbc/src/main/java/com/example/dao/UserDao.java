package com.example.dao;

import com.example.dao.interfaces.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDao implements IUser {

  //   @Autowired
  private JdbcTemplate jdbcTemplate;

  public UserDao() {}

  @Autowired
  public UserDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

//   @Autowired
  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public void createTable() {
    String sql =
      "CREATE TABLE IF NOT EXISTS users1 (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), email VARCHAR(255), password VARCHAR(255))";
    jdbcTemplate.execute(sql);
    System.out.println("Table created");
  }

  @Override
  public void insertUser(String name, String email, String password) {
    String sql = "INSERT INTO users1 (name, email, password) VALUES (?, ?, ?)";
    jdbcTemplate.update(sql, name, email, password);
    System.out.println("User inserted");
  }

  @Override
  public void getUser(int id) {
    String sql = "SELECT * FROM users1 WHERE id = ?";
    System.out.println(jdbcTemplate.queryForMap(sql, id));
  }

  @Override
  public void updateUser(int id, String name, String email, String password) {
    String sql =
      "UPDATE users1 SET name = ?, email = ?, password = ? WHERE id = ?";
    jdbcTemplate.update(sql, name, email, password, id);
    System.out.println("User updated");
  }

  @Override
  public void deleteUser(int id) {
    String sql = "DELETE FROM users1 WHERE id = ?";
    jdbcTemplate.update(sql, id);
  }

  @Override
  public void getAllUsers() {
    String sql = "SELECT * FROM users1";
    System.out.println(jdbcTemplate.queryForList(sql));
  }
}

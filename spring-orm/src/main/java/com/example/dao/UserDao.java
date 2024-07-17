package com.example.dao;

import com.example.models.User;

public interface UserDao {
  public int save(User user);

  public void update();

  public void delete();

  public void get();
}

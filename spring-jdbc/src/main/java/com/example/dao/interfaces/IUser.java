package com.example.dao.interfaces;

public interface IUser {

  public void createTable();

  public void insertUser(String name, String email, String password);

  public void getUser(int id);

  public void updateUser(int id, String name, String email, String password);

  public void deleteUser(int id);

  public void getAllUsers();
}

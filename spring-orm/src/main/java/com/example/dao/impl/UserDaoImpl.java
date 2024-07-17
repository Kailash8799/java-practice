package com.example.dao.impl;

import com.example.dao.UserDao;
import com.example.models.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDao")
public class UserDaoImpl implements UserDao {

  @Autowired
  private SessionFactory sessionFactory;

  public UserDaoImpl() {}

//   @Autowired
  public UserDaoImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  @Transactional
  public int save(User user) {
    sessionFactory.getCurrentSession().persist(user);
    return 1;
  }

  @Override
  public void update() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void delete() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public void get() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'get'");
  }
}

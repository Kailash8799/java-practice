package org.example.service.impl;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUserByEmail(Object email) {
        return null;
    }
}

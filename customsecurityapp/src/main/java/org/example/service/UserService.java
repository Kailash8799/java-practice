package org.example.service;

import org.example.model.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User getUserByEmail(Object email);
}

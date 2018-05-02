package com.example.prostrmk.demo.model;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(String login) {
        User user = new User();
        user.setName(login);
        user.setPassword("$2a$10$qYnUJjdaKRZ6LrLnx/6JleVS1CA3hi8K1VCVunT3hsIqYjmNtJ2vO");
        return user;
    }
}

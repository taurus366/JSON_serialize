package com.example.springdata.demo.service.impl;

import com.example.springdata.demo.dao.UserRepository;
import com.example.springdata.demo.entity.User;
import com.example.springdata.demo.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServuceImpl implements UserService {




    @Autowired
    private final UserRepository userRepository;

    public UserServuceImpl( UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User postUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

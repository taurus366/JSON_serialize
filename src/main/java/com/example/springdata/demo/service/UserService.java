package com.example.springdata.demo.service;

import com.example.springdata.demo.entity.User;

import java.util.List;

public interface UserService {

    User postUser(User user);
    List<User> getAllUsers();
}

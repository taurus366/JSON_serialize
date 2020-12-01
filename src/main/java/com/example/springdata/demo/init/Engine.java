package com.example.springdata.demo.init;

import com.example.springdata.demo.entity.User;
import com.example.springdata.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Engine implements CommandLineRunner {
    @Autowired
    private final UserService userService;

    public Engine(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setFirstName("Ali");
        user.setAge(26);
        user.setSalary(10000);

        userService.postUser(user);
    }
}

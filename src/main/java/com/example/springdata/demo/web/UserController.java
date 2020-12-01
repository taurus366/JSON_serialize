package com.example.springdata.demo.web;

import com.example.springdata.demo.entity.User;
import com.example.springdata.demo.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final Gson gson;

    @Autowired
    private final UserService userService;

    public UserController(Gson gson, UserService userService) {
        this.gson = gson;
        this.userService = userService;
    }

    @GetMapping(produces = "application/json")
    public String getUsers(){

        return gson.toJson(userService.getAllUsers());
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<String> addUser(@RequestBody String s){
        User user = gson.fromJson(s, User.class);
        User created = userService.postUser(user);
        System.out.println(created);

        return ResponseEntity.created(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .pathSegment("{id}")
                .buildAndExpand(created.getId()
                        .toString())
                .toUri())
                .body(gson
                        .toJson(created));
    }
}

package com.example.demo.controller;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public List<User> findAll() {
        System.out.println("进入了请求方法");
        return userMapper.findAll();
    }

    @GetMapping("/user/{userId}")
    public User findById(@PathVariable int userId) {
        return userMapper.findById(userId);
    }

    @PostMapping("/user")
    public void insertUser(@RequestBody User user) {
        userMapper.insertUser(user);
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody User user) {
        userMapper.updateUser(user);
    }

    @DeleteMapping("/user/{userId}")
    public void deleteById(@PathVariable int userId) {
        userMapper.deleteUser(userId);
    }
}
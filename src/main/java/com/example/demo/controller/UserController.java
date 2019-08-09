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
    @CrossOrigin(origins = "*")
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @GetMapping("/user/{userId}")
    public User findById(@PathVariable int userId) {
        return userMapper.findById(userId);
    }

    @PostMapping("/user")
    @CrossOrigin(origins = "*")
    public void insertUser(@RequestBody User user) {
        userMapper.insertUser(user);
    }

    @PutMapping("/user/{userId}")
    @CrossOrigin(origins = "*")
    public void updateUser(@PathVariable int userId, @RequestBody User user) {
        System.out.println("进入了请求方法");
        userMapper.updateUser(user);
    }

    @DeleteMapping("/user/{userId}")
    @CrossOrigin(origins = "*")
    public void deleteById(@PathVariable int userId) {
        userMapper.deleteUser(userId);
    }
}
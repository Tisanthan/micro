package com.example.tisuUserApp.controller;

import com.example.tisuUserApp.entity.users;
import com.example.tisuUserApp.repository.UserRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;
    @RequestMapping("/User")
    public List<users> getUsers() {
        return userRepository.findAll();
    }
    @RequestMapping("/{id}")
    public  List<users> getUsersForUser(@PathVariable("id")BigInteger id) {
        return userRepository.findByuserId(id);
    }
//    @RequestMapping("/{id}")
//    public  List<users> getUsersForCourse(@PathVariable("id")BigInteger id) {
//        return userRepository.findBycourseId(id);
//    }
}

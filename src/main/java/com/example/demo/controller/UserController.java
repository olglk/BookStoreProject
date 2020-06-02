package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.hibernate.annotations.GeneratorType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    UserRepository userRepository;
    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user/getall")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/user/custom/{id}")
    public List<User> finById(@PathVariable int id) {
        return userRepository.findById(id);
    }

    @GetMapping("/user/custom/starts/{prefix}")
    public List<User> findByNameStartingWith(@PathVariable String prefix) {
        return userRepository.findByNameStartingWith(prefix);
    }

    @GetMapping("/user/custom/contains/{infix}")
    public List<User> findByNameContaining(@PathVariable String infix) {
        return userRepository.findByNameContaining(infix);
    }

    @GetMapping("/user/custom/pattern/{pattern}")
    public List<User> findByNameLike(@PathVariable String pattern) {
        return userRepository.findByNameLike(pattern);
    }

    @GetMapping("/user/findlikeSQL/{infix}")
    public List<User> findLikeSQL(@PathVariable String infix) {
        return userRepository.findLikeSQL(infix);
    }

    @GetMapping("/user/findlikeJPQL/{infix}")
    public List<User> findLikeJPQL(@PathVariable String infix) {
        return userRepository.findLikeJPQL(infix);
    }
}

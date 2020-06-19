package com.example.demo.controller;

import com.example.demo.model.Adress;
import com.example.demo.model.User;
import com.example.demo.repository.AdressRepository;
import com.example.demo.repository.UserRepository;
import org.hibernate.annotations.GeneratorType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    UserRepository userRepository;
    AdressRepository adressRepository;
    UserController(UserRepository userRepository, AdressRepository adressRepository) {

        this.userRepository = userRepository;
        this.adressRepository = adressRepository;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    @GetMapping("/getall")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("getbyid/{id}")
    public User getUserById(@PathVariable int id) {
        return userRepository.findById(id).get();
    }

    @GetMapping("/custom/starts/{prefix}")
    public List<User> findByNameStartingWith(@PathVariable String prefix) {
        return userRepository.findByNameStartingWith(prefix);
    }

    @GetMapping("/custom/contains/{infix}")
    public List<User> findByNameContaining(@PathVariable String infix) {
        return userRepository.findByNameContaining(infix);
    }

    @GetMapping("/custom/pattern/{pattern}")
    public List<User> findByNameLike(@PathVariable String pattern) {
        return userRepository.findByNameLike(pattern);
    }

    @GetMapping("/findlikeSQL/{infix}")
    public List<User> findLikeSQL(@PathVariable String infix) {
        return userRepository.findLikeSQL(infix);
    }

    @GetMapping("/findlikeJPQL/{infix}")
    public List<User> findLikeJPQL(@PathVariable String infix) {
        return userRepository.findLikeJPQL(infix);
    }

    @GetMapping("/findby/{id1}/{id2}")
    public User findUserById (@PathVariable int id1, @PathVariable int id2) {
        Adress adress = adressRepository.findById(id1).get();
        User user = userRepository.findById(id2).get();
        user.setAdress(adress);
        return userRepository.save(user);
    }
}

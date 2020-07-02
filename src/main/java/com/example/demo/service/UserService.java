package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findByNameStartingWith(String prefix) {
        return userRepository.findByNameStartingWith(prefix);
    }

    public List<User> findByNameContaining(String infix) {
        return userRepository.findByNameContaining(infix);
    }

    public List<User> findByNameLike(String pattern) {
        return userRepository.findByNameLike(pattern);
    }

    public List<User> findLikeSQL(String infix) {
        return userRepository.findLikeSQL(infix);
    }

    public List<User> findLikeJPQL(String infix) {
        return userRepository.findLikeJPQL(infix);
    }


}

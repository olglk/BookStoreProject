package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceModuleTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    User user1;
    User user2;
    List<User> users = new ArrayList<>();

    @BeforeEach
    void setUp() {
        user1 = new User(1, "Alice");
        user2 = new User(2, "John");
//        users.add(user1);
//        users.add(user2);
    }

    @AfterEach
    void tearDown() {
        users.removeAll(users);
        user1 = null;
        user2 = null;
    }

    @Test
    void findByNameStartingWith() {
        users.add(user1);
        when(userRepository.findByNameStartingWith("A")).thenReturn(users);
        assertEquals(userRepository.findByNameStartingWith("A"), users);

        when(userService.findByNameStartingWith("A")).thenReturn(users);
        assertEquals(userService.findByNameStartingWith("A"), users);

        verify(userRepository, times(2)).findByNameStartingWith("A");
    }

    @Test
    void findByNameContaining() {
        users.add(user1);
        when(userRepository.findByNameContaining("l")).thenReturn(users);
        assertEquals(userRepository.findByNameContaining("l"), users);

        when(userService.findByNameContaining("l")).thenReturn(users);
        assertEquals(userService.findByNameContaining("l"), users);

        verify(userRepository, times(2)).findByNameContaining("l");
    }

    @Test
    void findByNameLike() {
        users.add(user1);
        when(userRepository.findByNameLike("i")).thenReturn(users);
        assertEquals(userRepository.findByNameLike("i"), users);

        when(userService.findByNameLike("i")).thenReturn(users);
        assertEquals(userService.findByNameLike("i"), users);

        verify(userRepository, times(2)).findByNameLike("i");
    }

    @Test
    void findLikeSQL() {
        users.add(user1);
        when(userRepository.findLikeSQL("c")).thenReturn(users);
        assertEquals(userRepository.findLikeSQL("c"), users);

        when(userService.findLikeSQL("c")).thenReturn(users);
        assertEquals(userService.findLikeSQL("c"), users);

        verify(userRepository, times(2)).findLikeSQL("c");
    }

    @Test
    void findLikeLPQL() {
        users.add(user1);
        when(userRepository.findLikeJPQL("e")).thenReturn(users);
        assertEquals(userRepository.findLikeJPQL("e"), users);

        when(userService.findLikeJPQL("e")).thenReturn(users);
        assertEquals(userService.findLikeJPQL("e"), users);

        verify(userRepository, times(2)).findLikeJPQL("e");
    }
}
package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.AdressRepository;
import com.example.demo.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerModuleTest {

    @Mock // содержимое
    UserRepository userRepository;
    @Mock
    AdressRepository adressRepository;

    @InjectMocks // обёртка
    UserController userController;

    User user1;
    User user2;
    List<User> users = new LinkedList<>();

    @BeforeEach
    void setUp() {
        user1 = new User(1, "Kate");
        user2 = new User(2, "Jake");
    }

    @AfterEach
    void tearDown() {
        user1 = null;
        user2 = null;
        users.removeAll(users);
    }

    @Test
    void addUser() {

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(userRepository.save(any(User.class))).thenReturn(user1);
        ResponseEntity<Object> responseEntity = userController.addUser(user1);

        Assertions.assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        Assertions.assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
    }

    @Test
    void getAll() {

        users.add(user1);
        users.add(user2);

        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userController.getAll();

        assertEquals(users, result);
        MatcherAssert.assertThat(users.get(0), equalTo(result.get(0)));
    }
}
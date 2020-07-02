package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.AdressRepository;
import com.example.demo.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTest {

    @MockBean
    UserRepository userRepository;
    @MockBean
    AdressRepository adressRepository;

    @Autowired
    private MockMvc mockMvc;

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
    @DisplayName("GET /users/getall")
    void getAllUsers() throws Exception {

        users.add(user1);
        users.add(user2);

        when(userRepository.findAll()).thenReturn(users);

        mockMvc.perform(get("/user/getall"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)));
    }

    @Test
    @DisplayName("POST /create")
    void createUser() throws Exception {
        users.add(user1);
        users.add(user2);

        when(userRepository.save(user1)).thenReturn(user1);

        mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(user1)))

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("GET/ /byname/kate")
    void findUserByName() throws Exception {
        users.add(user1);

        when(userRepository.findUserByName("Kate")).thenReturn(users);

        mockMvc.perform(get("/user/byname/{name}", "Kate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(user1)))

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
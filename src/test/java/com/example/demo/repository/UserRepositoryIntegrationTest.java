package com.example.demo.repository;

import com.example.demo.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
//@DataJpaTest
class UserRepositoryIntegrationTest {

    @Autowired
    UserRepository userRepository;
    User user1;
    User user2;
    List<User> users;

    @BeforeEach
    void setUp() {
        user1 = new User(1, "Alice");
        user2 = new User(2, "John");
        userRepository.save(user1);
        userRepository.save(user2);
        users = userRepository.findAll();
    }

    @AfterEach
    void tearDown() {
        userRepository.delete(user1);
        userRepository.delete(user2);
    }

    @Test
    void findByNameStartingWith() {
        assertEquals(userRepository.findByNameStartingWith("A").get(0), user1);
        assertThat(userRepository.findByNameStartingWith("A"), notNullValue());
        assertEquals(userRepository.findByNameStartingWith("G"), new ArrayList<User>());
        assertThat(userRepository.findByNameStartingWith("G"), equalTo(new ArrayList<User>()));
        assertThat(userRepository.findByNameStartingWith("G"), empty());
    }

    @Test
    void findByNameContaining() {
        assertEquals(userRepository.findByNameContaining("l").get(0), user1);
    }

    @Test
    void findByNameLike() {
        //assertEquals(userRepository.findByNameLike("l").get(0), user1);
        //assertEquals(userRepository.findByNameLike("o").get(0), user2);
        assertThat(userRepository.findByNameLike("i"), notNullValue());
        assertEquals(userRepository.findByNameLike("q"), new ArrayList<User>());
        //assertThat(userRepository.findByNameLike("h"), not(empty()));
    }

    @Test
    void findLikeSQL() {
        assertEquals(userRepository.findLikeSQL("l").get(0), user1);
        assertEquals(userRepository.findLikeSQL("o").get(0), user2);
        assertThat(userRepository.findLikeSQL("i"), notNullValue());
        assertEquals(userRepository.findLikeSQL("q"), new ArrayList<User>());

    }

    @Test
    void findLikeJPQL() {
        assertEquals(userRepository.findLikeJPQL("l").get(0), user1);
        assertEquals(userRepository.findLikeJPQL("o").get(0), user2);
        assertThat(userRepository.findLikeJPQL("i"), notNullValue());
        assertEquals(userRepository.findLikeJPQL("q"), new ArrayList<User>());
    }

    @Test
    void findById() {
        assertThrows(Exception.class, () -> userRepository.findById(16).get());
    }

    @Test
    @DisplayName("findbyname")
    void findByName() {
        assertEquals(userRepository.findUserByName("Alice").get(0), user1);
    }

}
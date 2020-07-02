package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public List<User> findByNameStartingWith(String prefix);
    public List<User> findByNameContaining(String infix);
    public List<User> findByNameLike(String pattern);
    public List<User> findUserByName(String name);

    @Query(value = "SELECT * FROM users WHERE name LIKE %?1%", nativeQuery = true)
    public List<User> findLikeSQL(String infix);

    @Query("SELECT u from User u WHERE u.name LIKE %?1%")
    public List<User> findLikeJPQL(String infix);

}

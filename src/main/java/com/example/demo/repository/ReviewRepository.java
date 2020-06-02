package com.example.demo.repository;

import com.example.demo.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    public List<Review> findByRatingGreaterThan(int rating);
    public List<Review> findByRatingBetween(int start, int end);
    //public List<Review> findByRatingIn(List<Integer> ratings);

    @Query(value = "SELECT * FROM reviews WHERE rating > 2 ORDER BY rating", nativeQuery = true)
    public List<Review> ratingSQL();

    @Query("SELECT r FROM Review r WHERE r.rating > 2 ORDER BY r.rating")
    public List<Review> ratingJPQL();
}

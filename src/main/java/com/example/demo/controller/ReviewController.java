package com.example.demo.controller;

import com.example.demo.model.Review;
import com.example.demo.repository.ReviewRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class ReviewController {
    ReviewRepository reviewRepository;
    ReviewController(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    @GetMapping("/review/custom/greater/{rating}")
    public List<Review> findByRatingGreaterThan(@PathVariable int rating) {
        return reviewRepository.findByRatingGreaterThan(rating);
    }

    @GetMapping("/review/custom/between/{start}/{end}")
    public List<Review> findByRatingBetween(@PathVariable int start, @PathVariable int end) {
        return reviewRepository.findByRatingBetween(start, end);
    }

    /*@GetMapping("/review/custom/in/{ratings}")
    public List<Review> findByRatingIn(@PathVariable List<Integer> ratings) {
        return reviewRepository.findByRatingIn(ratings);
    }*/

    @GetMapping("/review/ratingSQL")
    public List<Review> ratingSQL() {
        return reviewRepository.ratingSQL();
    }

    @GetMapping("/review/ratingJPQL")
    public List<Review> ratingJPQL() {
        return reviewRepository.ratingJPQL();
    }
}

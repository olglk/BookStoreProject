package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews")
public class Review implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int bookId;
    int id;
    String reviewerName;
    int rating;

//    @ManyToOne
//    private Book book;

//    @ManyToOne
//    @JoinColumn(name = "book_id")
//    private Book book;

}

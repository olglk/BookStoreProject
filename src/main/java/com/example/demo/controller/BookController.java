package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.BookReviewJoin;
import com.example.demo.repository.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    BookRepository bookRepository;
    BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @GetMapping("/book/custom/title/author/{title}/{author}")
    public List<Book> findByTitleOrAuthor(@PathVariable String title, @PathVariable String author) {
        return bookRepository.findByTitleOrAuthor(title, author);
    }

    /*@GetMapping("/book/review/joinSQL")
    public List<BookReviewJoin> booksReviewsSQL() {
        return bookRepository.booksReviewsSQL();
    }*/

    @GetMapping("/book/review/joinJPQL")
    public List<BookReviewJoin> booksReviewsJPQL() {
        return bookRepository.booksReviewsJPQL();
    }
}

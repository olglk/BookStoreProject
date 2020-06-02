package com.example.demo.repository;

import com.example.demo.model.Book;
import com.example.demo.model.BookReviewJoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    public List<Book> findByTitleOrAuthor(String title, String author);

    //@Query(value = "SELECT (books.title, reviews.reviewer_name) AS BookReviewJoin FROM books INNER JOIN reviews ON books.id = reviews.book_id", nativeQuery = true)
    //public List<BookReviewJoin> booksReviewsSQL();

    @Query("SELECT new com.example.demo.model.BookReviewJoin(b.title, r.reviewerName) FROM Book b INNER JOIN Review r ON b.id = r.bookId")
    public List<BookReviewJoin> booksReviewsJPQL();
}

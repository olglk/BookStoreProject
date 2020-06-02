package com.example.demo.controller.SingleTable;

import com.example.demo.model.SingleTable.Book1;
import com.example.demo.repository.SingleTable.Book1Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book1")
public class Book1Controller {

    Book1Repository book1Repository;

    Book1Controller(Book1Repository book1Repository) {
        this.book1Repository = book1Repository;
    }

    @GetMapping
    public List<Book1> getAll() {
        return book1Repository.findAll();
    }

    @PostMapping
    public Book1 post(@RequestBody Book1 book1) {
        return book1Repository.save(book1);
    }
}

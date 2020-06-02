package com.example.demo.repository.SingleTable;

import com.example.demo.model.SingleTable.Book1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Book1Repository extends JpaRepository<Book1, Integer> {
}

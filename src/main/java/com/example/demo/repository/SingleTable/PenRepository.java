package com.example.demo.repository.SingleTable;

import com.example.demo.model.SingleTable.Pen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenRepository extends JpaRepository<Pen, Integer> {
}

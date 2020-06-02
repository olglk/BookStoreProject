package com.example.demo.controller.SingleTable;

import com.example.demo.model.SingleTable.Pen;
import com.example.demo.repository.SingleTable.PenRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pen")
public class PenController {

    PenRepository penRepository;

    PenController(PenRepository penRepository) {
        this.penRepository = penRepository;
    }

    @GetMapping
    public List<Pen> getAll() {
        return penRepository.findAll();
    }

    @PostMapping
    public Pen post(@RequestBody Pen pen) {
        return penRepository.save(pen);
    }
}

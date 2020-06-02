package com.example.demo.controller.TablePerClass;

import com.example.demo.model.TablePerClass.Mersedes;
import com.example.demo.repository.TablePerClass.MersedesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mercedes")
public class MersedesController {

    MersedesRepository mersedesRepository;

    MersedesController(MersedesRepository mersedesRepository) {
        this.mersedesRepository = mersedesRepository;
    }

    @GetMapping
    public List<Mersedes> getAll() {
        return mersedesRepository.findAll();
    }

    @PostMapping
    public Mersedes post(@RequestBody Mersedes mersedes) {
        return mersedesRepository.save(mersedes);
    }
}

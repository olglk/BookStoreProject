package com.example.demo.controller.JoinedTable;

import com.example.demo.model.JoinedTable.Pet;
import com.example.demo.repository.JoinedTable.PetRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pet")
public class PetController {

    PetRepository petRepository;

    PetController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @GetMapping
    public List<Pet> getAll(){
        return petRepository.findAll();
    }

    @PostMapping
    public Pet post(@RequestBody Pet pet) {
        return petRepository.save(pet);
    }
}

package com.example.demo.controller;

import com.example.demo.model.Adress;
import com.example.demo.repository.AdressRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdressController {
    AdressRepository adressRepository;
    AdressController(AdressRepository adressRepository) {
        this.adressRepository = adressRepository;
    }

    @GetMapping("/adress/distinctSQL")
    public int distinctStatesSQL() {
        return adressRepository.distinctStatesSQL();
    }

    @GetMapping("/adress/distinctJPQL")
    public int distinctStatesJPQL() {
        return adressRepository.distinctStatesJPQL();
    }
}

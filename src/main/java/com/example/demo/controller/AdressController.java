package com.example.demo.controller;

import com.example.demo.model.Adress;
import com.example.demo.model.User;
import com.example.demo.repository.AdressRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adress")
public class AdressController {

    AdressRepository adressRepository;
    UserRepository userRepository;
    AdressController(AdressRepository adressRepository, UserRepository userRepository) {

        this.adressRepository = adressRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/getall")
    public List<Adress> getAllAdresses () {
        return adressRepository.findAll();
    }

    @GetMapping("/distinctSQL")
    public int distinctStatesSQL() {
        return adressRepository.distinctStatesSQL();
    }

    @GetMapping("/distinctJPQL")
    public int distinctStatesJPQL() {
        return adressRepository.distinctStatesJPQL();
    }

    @GetMapping("/findby/{id1}/{id2}")
    public Adress findAdressById (@PathVariable int id1, @PathVariable int id2) {
        Adress adress = adressRepository.findById(id1).get();
        User user = userRepository.findById(id2).get();
        adress.setUser(user);
        return adressRepository.save(adress);
    }

}

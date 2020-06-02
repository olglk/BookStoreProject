package com.example.demo.repository;

import com.example.demo.model.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Integer> {

    @Query(value = "SELECT COUNT(DISTINCT state) FROM adresses", nativeQuery = true)
    public int distinctStatesSQL();

    @Query("SELECT COUNT(DISTINCT a.state) FROM Adress a")
    public int distinctStatesJPQL();


}


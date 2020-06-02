package com.example.demo.repository.JoinedTable;

import com.example.demo.model.JoinedTable.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {
}

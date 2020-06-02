package com.example.demo.model.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee extends Person {
    private String company;
}

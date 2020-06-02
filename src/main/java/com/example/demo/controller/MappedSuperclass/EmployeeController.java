package com.example.demo.controller.MappedSuperclass;

import com.example.demo.model.MappedSuperclass.Employee;
import com.example.demo.repository.MappedSuperclass.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    EmployeeRepository employeeRepository;

    EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee post(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
}

package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.model.Salary;
import java.util.Optional;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salaries")
public class SalaryController {

    private final SalaryService salaryService;

    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @Autowired
    private EmployeeRepository employeeRepository; 

    @GetMapping
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalaries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salary> getSalaryById(@PathVariable Long id) {
        Salary salary = salaryService.getSalaryById(id);
        return ResponseEntity.of(java.util.Optional.ofNullable(salary));
    }

    @PostMapping
    public ResponseEntity<Salary> createSalary(@RequestBody Salary salary) {
        Salary savedSalary = salaryService.saveSalary(salary);
        return ResponseEntity.ok(savedSalary);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalary(@PathVariable Long id) {
        salaryService.deleteSalary(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<Salary>> getAllSalariesByEmployee(@PathVariable Long employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            List<Salary> salaries = salaryService.findAllSalariesByEmployee(employee);
            return ResponseEntity.ok(salaries);
        } else {
            // Handle case where employee with given ID is not found
            return ResponseEntity.notFound().build();
        }
}


}

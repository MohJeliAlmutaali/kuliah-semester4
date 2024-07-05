package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Employee;
import com.example.demo.model.Salary;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.SalaryRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private SalaryRepository salaryRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }
    
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Transactional
    public Salary saveSalary(Salary salary) {
        Salary savedSalary = salaryRepository.save(salary);
        updateEmployeeSalary(salary.getEmployee());
        return savedSalary;
    }

    public Employee saveEmployee(Employee employee) {
        // Lakukan penyimpanan employee
        Employee savedEmployee = employeeRepository.save(employee);

        // Hitung dan atur salary setelah menyimpan
        savedEmployee.calculateAndSetSalary();

        // Simpan kembali employee setelah mengatur salary
        return employeeRepository.save(savedEmployee);
    }

    @Transactional
    public void updateEmployeeSalary(Employee employee) {
        employee.calculateAndSetSalary();
        employeeRepository.save(employee);
    }
    
    @Transactional
    public void calculateAllSalaries() {
        List<Employee> employees = employeeRepository.findAll();
        for (Employee employee : employees) {
            employee.calculateAndSetSalary();
            // Hapus perubahan dari cache untuk menghindari kesalahan
            entityManager.flush();
            entityManager.clear();
            employeeRepository.save(employee);
        }
    }


    // tambahkan method lain sesuai kebutuhan
}

package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.Salary;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class SalaryService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SalaryRepository salaryRepository;

    public List<Salary> getAllSalaries() {
        return salaryRepository.findAll();
    }

    public Salary getSalaryById(Long id) {
        return salaryRepository.findById(id).orElse(null);
    }

    public Salary saveSalary(Salary salary) {
        return salaryRepository.save(salary);
    }

    public void deleteSalary(Long id) {
        salaryRepository.deleteById(id);
    }

    public Salary findByEmployeeAndMonthYear(Employee employee, LocalDate monthYear) {
        return salaryRepository.findByEmployeeAndMonthYear(employee, monthYear);
    }

    public List<Salary> findAllSalariesByEmployee(Employee employee) {
        return salaryRepository.findAllByEmployee(employee);
    }

    public BigDecimal calculateMonthlySalary(Employee employee, LocalDate monthYearDate) {
        Salary salary = findByEmployeeAndMonthYear(employee, monthYearDate);
        if (salary != null) {
            
            BigDecimal totalSalary = salary.getBaseSalary()
                    .add(salary.getAllowance())
                    .subtract(salary.getDeductions());
            return totalSalary;
        } else {
            throw new RuntimeException("Salary data not found for employee with ID: " + employee.getId());
        }
    }

    public void saveOrUpdateSalary(Salary salary) {
        // Simpan atau perbarui entitas Salary
        salaryRepository.save(salary);

        // Ambil Employee yang bersangkutan
        Employee employee = salary.getEmployee();

        // Hitung ulang salary-nya
        employee.calculateAndSetSalary();

        // Simpan kembali Employee setelah salary dihitung
        employeeRepository.save(employee);

        
    }

    
}

package com.example.demo.repository;

import com.example.demo.model.Employee;
import com.example.demo.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SalaryRepository extends JpaRepository<Salary, Long> {

    @Query("SELECT s FROM Salary s WHERE s.employee = :employee AND s.monthYear = :monthYear")
    Salary findByEmployeeAndMonthYear(@Param("employee") Employee employee, @Param("monthYear") LocalDate monthYear);

    List<Salary> findAllByEmployee(Employee employee);
}

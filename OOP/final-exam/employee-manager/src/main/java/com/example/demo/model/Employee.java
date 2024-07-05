package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import jakarta.persistence.PostLoad;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String phone;
    private String email;
    private String position;
    private String department;
    private LocalDate joinDate;

    private BigDecimal salary; // Total salary yang akan dihitung

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Salary> salaries; // Daftar salaries yang dimiliki oleh employee

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Attendance> attendances; // Daftar attendance yang dimiliki oleh employee

    public void calculateAndSetSalary() {
        BigDecimal totalSalary = BigDecimal.ZERO;
        if (salaries != null) {
            for (Salary salary : salaries) {
                BigDecimal baseSalary = salary.getBaseSalary() != null ? salary.getBaseSalary() : BigDecimal.ZERO;
                BigDecimal allowance = salary.getAllowance() != null ? salary.getAllowance() : BigDecimal.ZERO;
                BigDecimal deductions = salary.getDeductions() != null ? salary.getDeductions() : BigDecimal.ZERO;

                // Menghitung jumlah hadir
                int attendanceCount = 0;
                if (attendances != null) {
                    attendanceCount = (int) attendances.stream()
                            .filter(a -> "Hadir".equalsIgnoreCase(a.getStatus()))
                            .count();
                }

                // Menghitung jumlah Alfa
                int alfaCount = 0;
                if (attendances != null) {
                    alfaCount = (int) attendances.stream()
                            .filter(a -> "Alfa".equalsIgnoreCase(a.getStatus()))
                            .count();
                }

                // Menghitung allowance dan deductions berdasarkan attendanceCount dan alfaCount
                allowance = allowance.multiply(BigDecimal.valueOf(attendanceCount));
                deductions = deductions.multiply(BigDecimal.valueOf(alfaCount));

                BigDecimal employeeSalary = baseSalary.add(allowance).subtract(deductions);
                totalSalary = totalSalary.add(employeeSalary);
            }
        }
        this.salary = totalSalary;
    }

    @PostLoad
    public void onLoad() {
        calculateAndSetSalary();
    }
}

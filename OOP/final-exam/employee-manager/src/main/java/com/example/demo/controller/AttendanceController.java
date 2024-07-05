package com.example.demo.controller;

import com.example.demo.model.Attendance;
import com.example.demo.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    private final AttendanceService attendanceService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping("/employee/{employeeId}/count/{status}")
    public int countAttendanceByStatus(@PathVariable Long employeeId, @PathVariable String status) {
        return attendanceService.countByEmployeeIdAndStatus(employeeId, status);
    }
    

    @GetMapping("/employee/{employeeId}")
    public List<Attendance> getAttendanceByEmployeeId(@PathVariable Long employeeId) {
        return attendanceService.findByEmployeeId(employeeId);
    }

    @GetMapping
    public List<Attendance> getAllAttendances() {
        return attendanceService.getAllAttendances();
    }

    @GetMapping("/{id}")
    public Attendance getAttendanceById(@PathVariable Long id) {
        return attendanceService.getAttendanceById(id);
    }

    @PostMapping
    public Attendance createAttendance(@RequestBody Attendance attendance) {
        return attendanceService.saveAttendance(attendance);
    }

    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
    }
}

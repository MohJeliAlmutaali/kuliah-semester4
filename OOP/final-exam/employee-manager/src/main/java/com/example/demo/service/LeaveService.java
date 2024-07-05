package com.example.demo.service;

import com.example.demo.model.Leave;
import com.example.demo.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveService {
    private final LeaveRepository leaveRepository;

    @Autowired
    public LeaveService(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

    public List<Leave> getAllLeaves() {
        return leaveRepository.findAll();
    }

    public Leave getLeaveById(Long id) {
        return leaveRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave not found"));
    }

    public Leave saveLeave(Leave leave) {
        return leaveRepository.save(leave);
    }

    public void deleteLeave(Long id) {
        leaveRepository.deleteById(id);
    }
}

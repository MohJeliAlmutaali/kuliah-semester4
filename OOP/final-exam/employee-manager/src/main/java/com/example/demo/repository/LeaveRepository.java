package com.example.demo.repository;

import com.example.demo.model.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long> {
    // Tambahkan method kustom jika diperlukan
}

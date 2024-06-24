package com.jeli.gaji_guru.repository;

import com.jeli.gaji_guru.model.Guru;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuruRepository extends JpaRepository<Guru, Long> {
    void deleteByid(Long id);
}


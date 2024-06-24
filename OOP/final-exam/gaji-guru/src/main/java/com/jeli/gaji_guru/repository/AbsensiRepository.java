package com.jeli.gaji_guru.repository;


import com.jeli.gaji_guru.model.Absensi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbsensiRepository extends JpaRepository<Absensi, Long> {
    List<Absensi> findByGuruId(Long guruId);
    void deleteByGuruId(Long guruId);
}

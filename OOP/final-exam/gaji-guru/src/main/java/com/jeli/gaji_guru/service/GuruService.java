package com.jeli.gaji_guru.service;


import com.jeli.gaji_guru.model.Guru;
import com.jeli.gaji_guru.repository.GuruRepository;

import jakarta.transaction.Transactional;

import com.jeli.gaji_guru.repository.AbsensiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuruService {

    @Autowired
    private GuruRepository guruRepository;

    @Autowired
    private AbsensiRepository absensiRepository;

    @Transactional
    public void deleteGuruById(Long id) {
        // Hapus data terkait di tabel absensi
        absensiRepository.deleteByGuruId(id);
        // Hapus data guru
        guruRepository.deleteById(id);
    }

    public List<Guru> getAllGuru() {
        return guruRepository.findAll();
    }

    public Guru saveGuru(Guru guru) {
        return guruRepository.save(guru);
    }

    public Guru getGuruById(Long id) {
        return guruRepository.findById(id).orElse(null);
    }
}


package com.jeli.gaji_guru.service;


import com.jeli.gaji_guru.model.Absensi;
import com.jeli.gaji_guru.repository.AbsensiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbsensiService {

    @Autowired
    private AbsensiRepository absensiRepository;

    public List<Absensi> getAbsensiByGuruId(Long guruId) {
        return absensiRepository.findByGuruId(guruId);
    }

    public Absensi saveAbsensi(Absensi absensi) {
        return absensiRepository.save(absensi);
    }
}

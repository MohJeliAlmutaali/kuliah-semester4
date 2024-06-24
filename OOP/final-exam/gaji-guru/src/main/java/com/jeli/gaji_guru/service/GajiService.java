package com.jeli.gaji_guru.service;


import com.jeli.gaji_guru.model.Absensi;
import com.jeli.gaji_guru.model.Gaji;
import com.jeli.gaji_guru.model.Guru;
import com.jeli.gaji_guru.repository.AbsensiRepository;
import com.jeli.gaji_guru.repository.GuruRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GajiService {

    @Autowired
    private GuruRepository guruRepository;

    @Autowired
    private AbsensiRepository absensiRepository;

    public boolean updateGaji(Long guruId, double gajiPokok, double tunjanganTransportasi) {
        Optional<Guru> optionalGuru = guruRepository.findById(guruId);
        if (!optionalGuru.isPresent()) {
            return false; // Mengembalikan false jika guru tidak ditemukan
        }

        Guru guru = optionalGuru.get();
        guru.setGajiPokok(gajiPokok);
        guru.setTunjanganTransportasi(tunjanganTransportasi);

        // totalGaji akan otomatis terupdate di dalam setter masing-masing

        guruRepository.save(guru); // Menyimpan perubahan ke dalam database

        return true; // Mengembalikan true jika update berhasi
    }

    public Gaji hitungGaji(Long guruId) {
        // Mengambil informasi guru dari repository berdasarkan ID
        Guru guru = guruRepository.findById(guruId).orElse(null);
        if (guru == null) {
            return null; // Mengembalikan null jika guru tidak ditemukan
        }

        // Mengambil daftar absensi guru berdasarkan ID
        List<Absensi> absensiList = absensiRepository.findByGuruId(guruId);

        // Menghitung jumlah hari hadir dari absensi
        long jumlahHariHadir = absensiList.stream().filter(Absensi::isHadir).count();

        // Menghitung tunjangan transportasi berdasarkan jumlah hari hadir
        double tunjanganTransportasi = guru.getTunjanganTransportasi() * jumlahHariHadir;

        // Membuat objek Gaji baru dan mengatur nilainya
        Gaji gaji = new Gaji();
        gaji.setGajiPokok(guru.getGajiPokok());
        gaji.setTunjanganTransportasi(tunjanganTransportasi / jumlahHariHadir);
        gaji.setTotalGaji(guru.getGajiPokok() + tunjanganTransportasi);

        guru.setTotalGaji(gaji.getTotalGaji());
        guruRepository.save(guru);

        return gaji; // Mengembalikan objek Gaji yang sudah dihitung
    }
}


package com.jeli.gaji_guru.controller;

import com.jeli.gaji_guru.model.Gaji;
import com.jeli.gaji_guru.service.GajiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gaji")
public class GajiController {

    @Autowired
    private GajiService gajiService;

    // Endpoint untuk menghitung gaji berdasarkan ID guru
    @GetMapping("/{guruId}")
    public Gaji hitungGaji(@PathVariable Long guruId) {
        return gajiService.hitungGaji(guruId);
    }

    // Endpoint untuk update data gaji berdasarkan ID dari parameter URL
    @PutMapping("/{guruId}")
    public ResponseEntity<String> updateGaji(@PathVariable Long guruId,
                                             @RequestBody GajiRequest request) {
        boolean updated = gajiService.updateGaji(guruId, request.getGajiPokok(), request.getTunjanganTransportasi());
        if (updated) {
            return ResponseEntity.ok("Data gaji berhasil diupdate");
        } else {
            return ResponseEntity.badRequest().body("Gagal mengupdate data gaji. Guru tidak ditemukan.");
        }
    }

    // Kelas request untuk menampung data gaji yang dikirim melalui body request
    public static class GajiRequest {
        private double gajiPokok;
        private double tunjanganTransportasi;

        public double getGajiPokok() {
            return gajiPokok;
        }

        public void setGajiPokok(double gajiPokok) {
            this.gajiPokok = gajiPokok;
        }

        public double getTunjanganTransportasi() {
            return tunjanganTransportasi;
        }

        public void setTunjanganTransportasi(double tunjanganTransportasi) {
            this.tunjanganTransportasi = tunjanganTransportasi;
        }
}
}
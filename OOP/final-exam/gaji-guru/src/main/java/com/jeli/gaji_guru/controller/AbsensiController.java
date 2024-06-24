package com.jeli.gaji_guru.controller;

import com.jeli.gaji_guru.model.Absensi;
import com.jeli.gaji_guru.service.AbsensiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/api/absensi")
public class AbsensiController {

    @Autowired
    private AbsensiService absensiService;

    @GetMapping("/tambah-absensi")
    @ResponseBody
    public String getAbsensiPage() throws IOException {
        ClassPathResource resource = new ClassPathResource("static/absensi.html");
        try (Reader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        }
    }

    @GetMapping("/{guruId}")
    public List<Absensi> getAbsensiByGuruId(@PathVariable Long guruId) {
        return absensiService.getAbsensiByGuruId(guruId);
    }

    @PostMapping
    public Absensi addAbsensi(@RequestBody Absensi absensi) {
        return absensiService.saveAbsensi(absensi);
    }
}

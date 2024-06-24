package com.jeli.gaji_guru.controller;

import com.jeli.gaji_guru.model.Guru;
import com.jeli.gaji_guru.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.io.Reader;

@RestController
@RequestMapping("/api/guru")
public class GuruController {

    @Autowired
    private GuruService guruService;


    @GetMapping("/tambah-guru")
    @ResponseBody
    public String getGuruPage() throws IOException {
        ClassPathResource resource = new ClassPathResource("static/tambah-guru.html");
        try (Reader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        }
    }
    

    @GetMapping
    public List<Guru> getAllGuru() {
        return guruService.getAllGuru();
    }

    @PostMapping
    public Guru addGuru(@RequestBody Guru guru) {
        return guruService.saveGuru(guru);
    }

    @GetMapping("/{id}")
    public Guru getGuruById(@PathVariable Long id) {
        return guruService.getGuruById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGuruByid(@PathVariable Long id){
        guruService.deleteGuruById(id);
    }
}

package com.jeli.gaji_guru.model;


import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class Guru {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nama;
    private String tingkatPendidikan;
    private int tahunPengalaman;
    private String lokasi;
    private double gajiPokok;
    private double tunjanganTransportasi;
    private double totalGaji;
}

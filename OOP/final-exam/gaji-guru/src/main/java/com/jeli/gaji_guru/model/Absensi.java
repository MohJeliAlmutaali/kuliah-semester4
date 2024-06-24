package com.jeli.gaji_guru.model;


import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Absensi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "guru_id", referencedColumnName = "id")  // Kolom 'guru_id' di tabel 'absensi' merujuk ke kolom 'id' di tabel 'guru'
    private Guru guru;
    private LocalDate tanggal;
    private boolean hadir;
}


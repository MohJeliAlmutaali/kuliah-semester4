// src/main/resources/static/js/tambah-guru.js

document.addEventListener('DOMContentLoaded', function () {
    // Tambah event listener untuk form tambah guru
    const formTambahGuru = document.getElementById('formTambahGuru');
    formTambahGuru.addEventListener('submit', function (event) {
        event.preventDefault(); // Menghentikan pengiriman form

        // Mengambil nilai input dari form
        const nama = document.getElementById('nama').value;
        const tingkatPendidikan = document.getElementById('tingkatPendidikan').value;
        const tahunPengalaman = document.getElementById('tahunPengalaman').value;
        const lokasi = document.getElementById('lokasi').value;

        // Validasi tahun pengalaman (minimal 0 tahun)
        if (isNaN(tahunPengalaman) || parseInt(tahunPengalaman) < 0) {
            alert('Tahun pengalaman harus berupa angka dan minimal 0 tahun.');
            return;
        }

        // Menyiapkan data untuk dikirimkan ke backend
        const data = {
            nama: nama,
            tingkatPendidikan: tingkatPendidikan,
            tahunPengalaman: parseInt(tahunPengalaman), // Konversi ke integer
            lokasi: lokasi
        };

        // Mengirimkan data dengan metode POST ke endpoint yang sesuai
        fetch('/api/guru', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Gagal menambahkan guru');
            }
            return response.json();
        })
        .then(guru => {
            // Menampilkan pesan sukses atau melakukan navigasi ke halaman lain
            alert(`Guru dengan nama ${guru.nama} berhasil ditambahkan!`);
            window.location.href = '/'; // Mengarahkan kembali ke halaman utama setelah tambah guru
        })
        .catch(error => {
            console.error('Error tambah guru:', error);
            alert('Terjadi kesalahan saat menambahkan guru, silakan coba lagi.');
        });
    });
});

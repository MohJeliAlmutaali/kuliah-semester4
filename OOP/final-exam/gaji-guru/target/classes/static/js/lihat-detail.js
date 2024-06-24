async function fetchGajiDetail(guruId) {
    try {
        const response = await fetch(`/api/gaji/${guruId}`);
        if (!response.ok) {
            throw new Error('Gagal mengambil data gaji');
        }
        const gaji = await response.json();
        // Memperbarui UI dengan data gaji yang diterima
        document.getElementById('gaji-pokok').textContent = gaji.gajiPokok;
        document.getElementById('tunjangan-transportasi').textContent = gaji.tunjanganTransportasi;
        document.getElementById('total-gaji').textContent = gaji.totalGaji;
    } catch (error) {
        console.error('Terjadi kesalahan:', error);
        alert('Terjadi kesalahan saat mengambil data gaji');
    }
}

// Fungsi untuk memulai aplikasi setelah halaman dimuat
window.onload = function() {
    // Mendapatkan guruId dari parameter URL
    const urlParams = new URLSearchParams(window.location.search);
    const guruId = urlParams.get('id');
    if (guruId) {
        // Memanggil fungsi untuk mengambil detail gaji berdasarkan guruId
        fetchGajiDetail(guruId);
    } else {
        alert('Parameter guruId tidak ditemukan dalam URL');
    }
};
// Function untuk mendapatkan data gaji dari server berdasarkan guruId
function fetchGajiData(guruId) {
    fetch(`/api/gaji/${guruId}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Gagal mendapatkan data gaji.');
            }
            return response.json();
        })
        .then(data => {
            // Mengisi nilai awal form dengan data gaji yang diperoleh
            document.getElementById("gajiPokok").value = data.gajiPokok;
            document.getElementById("tunjanganTransportasi").value = data.tunjanganTransportasi ;
            document.getElementById("guruId").value = guruId; // Set guruId pada input hidden
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Terjadi kesalahan saat memuat data gaji.');
        });
}

// Function untuk melakukan update data gaji
function updateGaji() {
    const guruId = document.getElementById("guruId").value;
    const gajiPokok = document.getElementById("gajiPokok").value;
    const tunjanganTransportasi = document.getElementById("tunjanganTransportasi").value;

    const data = {
        gajiPokok: parseFloat(gajiPokok),
        tunjanganTransportasi: parseFloat(tunjanganTransportasi)
    };

    fetch(`/api/gaji/${guruId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Gagal update data gaji.');
        }
        alert('Data gaji berhasil diupdate.');
        window.location.href = "../index.html"
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Terjadi kesalahan saat melakukan update.');
    });
}

// Mendapatkan nilai guruId dari parameter URL
const urlParams = new URLSearchParams(window.location.search);
const guruId = urlParams.get('id');

// Memanggil fungsi untuk mengambil data gaji dari server
fetchGajiData(guruId);




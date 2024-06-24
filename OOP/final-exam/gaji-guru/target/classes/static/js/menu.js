document.addEventListener('DOMContentLoaded', function () {
    // Fetch dan tampilkan daftar guru saat halaman dimuat
    fetchGuruList();

    // Tambah event listener untuk tombol Tambah Guru
    document.getElementById('btnTambahGuru').addEventListener('click', function () {
        // Redirect atau navigasi ke halaman tambah guru
        window.location.href = '/tambah-guru.html';
    });
    // Tambah event listener untuk tombol Lihat Detail pada setiap baris guru
    document.addEventListener('click', function (event) {
        if (event.target.classList.contains('btnLihatDetail')) {
            const guruId = event.target.getAttribute('data-guruid');
            if (guruId) {
                // Redirect atau navigasi ke halaman detail guru dengan ID yang sesuai
                window.location.href = `./../lihat-detail.html?id=${guruId}`;
            }
        }
    });

    document.addEventListener('click', function (event) {
        if (event.target.classList.contains('btnEdit')) {
            const guruId = event.target.getAttribute('data-guruid');
            if (guruId) {
                // Redirect atau navigasi ke halaman detail guru dengan ID yang sesuai
                window.location.href = `./../update-gaji.html?id=${guruId}`;
            }
        }
    });

    document.addEventListener('click', function (event) {
        if (event.target.classList.contains('btnDelete')) {
            const guruId = event.target.getAttribute('data-guruid');
            if (guruId) {
                const url = `http://localhost:8080/api/guru/delete/${guruId}`
                fetch(url, {
                    method: 'DELETE'
                })
                .then(response => {
                    if (response.ok){
                        alert(`Guru dengan id ${guruId} berhasil dihapus`)
                        document.getElementById(`guru-${guruId}`).remove();
                    }
                    else {
                        alert(`Gagal Mengahapus data Guru`)
                    }
                    
                })
            }
        }
    });

});

// Function untuk mengambil dan menampilkan daftar guru
function fetchGuruList() {
    fetch('/api/guru')
        .then(response => response.json())
        .then(data => {
            const guruTableBody = document.getElementById('guruTableBody');
            guruTableBody.innerHTML = '';
            data.forEach(guru => {
                const row = document.createElement('tr');
                row.id = `guru-${guru.id}`;
                row.innerHTML = `
                <td class="px-6 py-4 whitespace-nowrap text-sm font-semibold text-gray-900">${guru.nama}</td>
                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">${guru.tingkatPendidikan}</td>
                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">${guru.tahunPengalaman}</td>
                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">${guru.lokasi}</td>
                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500" id="gaji-${guru.id}">Loading...</td>
                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                    <button class="text-white bg-indigo-600 hover:bg-indigo-700 px-3 py-1 rounded-lg mr-2 transition duration-300 ease-in-out transform hover:scale-105 btnLihatDetail" data-guruid="${guru.id}">Lihat Detail</button>
                    <button class="text-white bg-green-600 hover:bg-green-700 px-3 py-1 rounded-lg mr-2 transition duration-300 ease-in-out transform hover:scale-105 btnEdit" data-guruid="${guru.id}">Edit</button>
                    <button class="text-white bg-red-600 hover:bg-red-700 px-3 py-1 rounded-lg mr-2 transition duration-300 ease-in-out transform hover:scale-105 btnDelete" data-guruid="${guru.id}">Delete</button>

                    
                    
                </td>
                
                `;
                guruTableBody.appendChild(row);

                // Fetch gaji for each guru
                fetch(`/api/gaji/${guru.id}`)
                    .then(response => response.json())
                    .then(gajiData => {
                        const gajiCell = document.getElementById(`gaji-${guru.id}`);
                        if (gajiCell) {
                            gajiCell.textContent = `Total: ${gajiData.totalGaji}`;
                        }
                    })
                    .catch(error => {
                        const gajiCell = document.getElementById(`gaji-${guru.id}`);
                        if (gajiCell) {
                            gajiCell.textContent = 'Error';
                        }
                        console.error('Error fetching gaji:', error);
                    });
            });
        })
        .catch(error => console.error('Error fetching guru:', error));
}

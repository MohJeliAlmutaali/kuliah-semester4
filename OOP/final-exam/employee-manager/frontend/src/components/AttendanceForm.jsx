import React, { useState } from 'react';
import axios from 'axios';

const AttendanceForm = () => {
  const [formData, setFormData] = useState({
    employeeId: '',
    date: '',
    status: '',
    startDate: '',
    endDate: '',
    reason: ''
  });

  const [successMessage, setSuccessMessage] = useState('');
  const [errorMessage, setErrorMessage] = useState('');

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value
    });
  };

  const handleSubmit = async (e) => {
  e.preventDefault();
  try {
    let attendanceData = {
      employee: { id: formData.employeeId },
      date: formData.date,
      status: formData.status
    };

    let leaveData = {};

    if (formData.status === 'Cuti') {
      leaveData = {
        employee: { id: formData.employeeId },
        startDate: formData.startDate,
        endDate: formData.endDate,
        reason: formData.reason
      };
    }

    // Kirim data ke endpoint attendance
    const attendanceResponse = await axios.post('http://localhost:8080/api/attendance', attendanceData);
    console.log('Attendance submitted:', attendanceResponse.data);

    // Kirim data ke endpoint leave jika status adalah 'Cuti'
    if (formData.status === 'Cuti') {
      const leaveResponse = await axios.post('http://localhost:8080/api/leave', leaveData);
      console.log('Leave submitted:', leaveResponse.data);
    }

    setSuccessMessage('Data absensi berhasil disubmit!');
    setErrorMessage('');
    setFormData({
      employeeId: '',
      date: '',
      status: '',
      startDate: '',
      endDate: '',
      reason: ''
    });
  } catch (error) {
    console.error('There was an error submitting the form!', error);
    setErrorMessage('Terjadi kesalahan saat mengirim data absensi.');
    setSuccessMessage('');
  }
};


  return (
    <div className="max-w-md mx-auto mt-10 p-6 bg-white rounded-lg shadow-md">
      <h2 className="text-2xl font-bold mb-6 text-center">Form Absensi</h2>
      {successMessage && (
        <div className="mb-4 text-green-600 text-center">
          {successMessage}
        </div>
      )}
      {errorMessage && (
        <div className="mb-4 text-red-600 text-center">
          {errorMessage}
        </div>
      )}
      <form onSubmit={handleSubmit}>
        <div className="mb-4">
          <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="employeeId">
            ID Karyawan
          </label>
          <input
            type="text"
            name="employeeId"
            id="employeeId"
            value={formData.employeeId}
            onChange={handleChange}
            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            required
          />
        </div>
        <div className="mb-4">
          <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="date">
            Tanggal
          </label>
          <input
            type="date"
            name="date"
            id="date"
            value={formData.date}
            onChange={handleChange}
            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            required
          />
        </div>
        <div className="mb-4">
          <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="status">
            Status Kehadiran
          </label>
          <select
            name="status"
            id="status"
            value={formData.status}
            onChange={handleChange}
            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            required
          >
            <option value="">Pilih Status</option>
            <option value="Hadir">Hadir</option>
            <option value="Alfa">Alfa</option>
            <option value="Cuti">Cuti</option>
            <option value="Sakit">Sakit</option>
            <option value="Izin">Izin</option>
          </select>
        </div>
        {formData.status === 'Cuti' && (
          <>
            <div className="mb-4">
              <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="startDate">
                Tanggal Mulai
              </label>
              <input
                type="date"
                name="startDate"
                id="startDate"
                value={formData.startDate}
                onChange={handleChange}
                className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                required
              />
            </div>
            <div className="mb-4">
              <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="endDate">
                Tanggal Akhir
              </label>
              <input
                type="date"
                name="endDate"
                id="endDate"
                value={formData.endDate}
                onChange={handleChange}
                className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                required
              />
            </div>
            <div className="mb-4">
              <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="reason">
                Alasan Cuti
              </label>
              <textarea
                name="reason"
                id="reason"
                value={formData.reason}
                onChange={handleChange}
                className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                required
              />
            </div>
          </>
        )}
        <div className="flex items-center justify-between">
          <button
            type="submit"
            className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
          >
            Submit
          </button>
        </div>
      </form>
    </div>
  );
};

export default AttendanceForm;

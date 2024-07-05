import React, { useState } from 'react';
import axios from 'axios';

const SalaryForm = () => {
  const [formData, setFormData] = useState({
    employeeId: '',
    monthYear: '',
    baseSalary: '',
    allowance: '',
    deductions: ''
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
      const response = await axios.post('http://localhost:8080/api/salaries', {
        employee: { id: formData.employeeId }, // Mengikuti format data yang dikirimkan
        monthYear: formData.monthYear,
        baseSalary: formData.baseSalary,
        allowance: formData.allowance,
        deductions: formData.deductions
      });
      console.log(response.data);
      setSuccessMessage('Data gaji berhasil disubmit!');
      setErrorMessage('');
      // Reset form jika diperlukan
      setFormData({
        employeeId: '',
        monthYear: '',
        baseSalary: '',
        allowance: '',
        deductions: ''
      });
    } catch (error) {
      console.error('Terjadi kesalahan saat mengirim data gaji!', error);
      setErrorMessage('Terjadi kesalahan saat mengirim data gaji.');
      setSuccessMessage('');
    }
  };

  return (
    <div className="max-w-md mx-auto mt-10 p-6 bg-white rounded-lg shadow-md">
      <h2 className="text-2xl font-bold mb-6 text-center">Form Input Gaji</h2>
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
          <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="monthYear">
            Bulan dan Tahun
          </label>
          <input
            type="date"
            name="monthYear"
            id="monthYear"
            value={formData.monthYear}
            onChange={handleChange}
            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            required
          />
        </div>
        <div className="mb-4">
          <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="baseSalary">
            Gaji Pokok
          </label>
          <input
            type="number"
            name="baseSalary"
            id="baseSalary"
            value={formData.baseSalary}
            onChange={handleChange}
            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            required
          />
        </div>
        <div className="mb-4">
          <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="allowance">
            Tunjangan
          </label>
          <input
            type="number"
            name="allowance"
            id="allowance"
            value={formData.allowance}
            onChange={handleChange}
            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
          />
        </div>
        <div className="mb-4">
          <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="deductions">
            Potongan
          </label>
          <input
            type="number"
            name="deductions"
            id="deductions"
            value={formData.deductions}
            onChange={handleChange}
            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
          />
        </div>
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

export default SalaryForm;

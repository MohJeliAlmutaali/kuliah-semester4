import React, { useState, useEffect } from 'react';
import Calendar from 'react-calendar';
import 'react-calendar/dist/Calendar.css';
import './calendar.css'; // Pastikan ini menunjuk ke file CSS yang benar
import axios from 'axios';

const CalendarComponent = ({ employeeId, allowance, baseSalary, deductions }) => {
  const [attendanceData, setAttendanceData] = useState([]);
  const [statusCount, setStatusCount] = useState({
    Sakit: 0,
    Alfa: 0,
    Izin: 0,
    Cuti: 0
  });

  useEffect(() => {
    const fetchAttendanceData = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/api/attendance/employee/${employeeId}`);
        setAttendanceData(response.data);
      } catch (error) {
        console.error('Error fetching attendance data:', error);
      }
    };

    fetchAttendanceData();
  }, [employeeId]);

  useEffect(() => {
    const countStatus = () => {
      const count = {
        Hadir: 0,
        Sakit: 0,
        Alfa: 0,
        Izin: 0,
        Cuti: 0
      };

      attendanceData.forEach(attendance => {
        count[attendance.status]++;
      });

      setStatusCount(count);
    };

    countStatus();
  }, [attendanceData]);

  const getClassForStatus = (status) => {
    switch (status) {
      case 'Hadir':
        return 'hadir';
      case 'Sakit':
        return 'sakit';
      case 'Alfa':
        return 'alfa';
      case 'Izin':
        return 'izin';
      case 'Cuti':
        return 'cuti';
      default:
        return '';
    }
  };

  const tileClassName = ({ date, view }) => {
    if (view === 'month') {
      const attendanceForDate = attendanceData.find(attendance =>
        new Date(attendance.date).toDateString() === date.toDateString()
      );

      if (attendanceForDate) {
        return `react-calendar__tile--active ${getClassForStatus(attendanceForDate.status)}`;
      }
    }
    return '';
  };

  return (
    <div className="grid grid-cols-2 gap-4">
      <div className="p-8">
        <Calendar
          tileClassName={tileClassName}
          value={new Date()}
        />
      </div>
      <div className="p-6 bg-gray-300 text-sm">
        <ul>
        <h3 className="text-xl font-semibold mb-2">Ketentuan:</h3>
        <li className="flex items-center mb-2">
            <span className="inline-block w-4 h-4 mr-2"></span>
            <span>Base Allowance x Hadir = {allowance} x {statusCount.Hadir}</span>
          </li>
          <li className="flex items-center mb-2">
            <span className="inline-block w-4 h-4 mr-2"></span>
            <span>Base Deductions x Alfa = {deductions} x {statusCount.Alfa}</span>
          </li>
        <h3 className="text-xl font-semibold mb-2">Gaji dan Potongan:</h3>
          <li className="flex items-center mb-2">
            <span className="inline-block w-4 h-4 mr-2"></span>
            <span>Allowance: {allowance * statusCount.Hadir}</span>
          </li>
          <li className="flex items-center mb-2">
            <span className="inline-block w-4 h-4 mr-2"></span>
            <span>Base Salary: {baseSalary}</span>
          </li>
          <li className="flex items-center mb-2">
            <span className="inline-block w-4 h-4 mr-2"></span>
            <span>Deductions: {deductions * statusCount.Alfa}</span>
          </li>
          <li className="flex items-center mb-2">
            <span className="inline-block w-4 h-4 mr-2"></span>
            <span>Total Gaji: {baseSalary + (allowance * statusCount.Hadir) - (deductions * statusCount.Alfa)}</span>
          </li>
        </ul>
        <div className="mt-4">
          <h3 className="text-xl font-semibold mb-2">Keterangan Warna:</h3>
          <ul>
            <li className="flex items-center mb-2">
              <span className="inline-block w-4 h-4 bg-blue-700 rounded-full mr-2"></span>
              <span>Hadir: {statusCount.Hadir}</span>
            </li>
            <li className="flex items-center mb-2">
              <span className="inline-block w-4 h-4 bg-green-800 rounded-full mr-2"></span>
              <span>Sakit: {statusCount.Sakit}</span>
            </li>
            <li className="flex items-center mb-2">
              <span className="inline-block w-4 h-4 bg-red-600 rounded-full mr-2"></span>
              <span>Alfa: {statusCount.Alfa}</span>
            </li>
            <li className="flex items-center mb-2">
              <span className="inline-block w-4 h-4 bg-yellow-400 rounded-full mr-2"></span>
              <span>Izin: {statusCount.Izin}</span>
            </li>
            <li className="flex items-center mb-2">
              <span className="inline-block w-4 h-4 bg-purple-500 rounded-full mr-2"></span>
              <span>Cuti: {statusCount.Cuti}</span>
            </li>
          </ul>
        </div>
      </div>
    </div>
  );
};

export default CalendarComponent;

import React, { useState, useEffect } from 'react';
import Calendar from 'react-calendar';
import 'react-calendar/dist/Calendar.css';
import axios from 'axios';

const LeaveCalender = ({ employeeId }) => {
  const [attendanceData, setAttendanceData] = useState([]);

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

  const getClassForStatus = (status) => {
    switch (status) {
      case 'Hadir':
        return '';
      case 'Alfa':
        return 'bg-red-500 text-red-300';
      case 'Cuti':
        return 'bg-yellow-500 text-yellow-300';
      case 'izin':
        return 'bg-blue-500 text-sky-300';
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
        return getClassForStatus(attendanceForDate.status);
      }
    }
    return '';
  };

  return (
    <div className="p-8">
      <Calendar
        tileClassName={tileClassName}
        value={new Date()}
      />
    </div>
  );
};

export default LeaveCalender;

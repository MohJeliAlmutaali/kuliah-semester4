import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import EmployeeList from './components/EmployeeList';
import EmployeeDetail from './components/EmployeeDetail'; // Pastikan file ini diimpor
import SalaryForm from './components/SalaryForm';
import AttendanceCalendar from './components/AttendaceCalender';
import AttendanceForm from './components/AttendanceForm';
import LeaveCalender from './components/LeaveCalender';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<EmployeeList />} />
        <Route path="/salary-form" element={<SalaryForm />} />
        <Route path="/Attendance-calender" element={<AttendanceCalendar />} />
        <Route path="/Attendance-form" element={<AttendanceForm />} />
        <Route path="/calender" element={<LeaveCalender />} />
        <Route path="/employee/:id" element={<EmployeeDetail />} />
      </Routes>
    </Router>
  );
}

export default App;

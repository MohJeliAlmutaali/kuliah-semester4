import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import AttendanceCalendar from './AttendaceCalender';
import 'react-calendar/dist/Calendar.css';

const EmployeeDetail = () => {
  const { id } = useParams(); // Ambil nilai id dari URL
  const [activeTab, setActiveTab] = useState('salary');
  const [salaryDetails, setSalaryDetails] = useState([]);
  const [attendanceDetails, setAttendanceDetails] = useState([]);

  const handleTabChange = (tab) => {
    setActiveTab(tab);
  };

  useEffect(() => {
    const fetchSalaryDetails = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/api/salaries/employee/${id}`);
        setSalaryDetails(response.data);
      } catch (error) {
        console.error('Error fetching salary details:', error);
      }
    };

    const fetchAttendanceDetails = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/api/attendance/employee/${id}`);
        setAttendanceDetails(response.data);
      } catch (error) {
        console.error('Error fetching attendance details:', error);
      }
    };

    if (activeTab === 'salary') {
      fetchSalaryDetails();
    } else if (activeTab === 'attendance') {
      fetchAttendanceDetails();
    }
  }, [activeTab, id]);

  return (
    <div className="container mx-auto mt-8">
      <h2 className="text-3xl font-semibold text-gray-800 mb-6">Employee Detail</h2>
      <div className="flex space-x-4">
        <button
          className={`py-2 px-4 text-sm rounded-tl-lg rounded-tr-lg focus:outline-none ${
            activeTab === 'salary' ? 'bg-blue-500 text-white' : 'bg-gray-200 text-gray-800'
          }`}
          onClick={() => handleTabChange('salary')}
        >
          Salary Details
        </button>
        <button
          className={`py-2 px-4 text-sm rounded-tl-lg rounded-tr-lg focus:outline-none ${
            activeTab === 'attendance' ? 'bg-blue-500 text-white' : 'bg-gray-200 text-gray-800'
          }`}
          onClick={() => handleTabChange('attendance')}
        >
          Attendance Records
        </button>
      </div>
      <div className="mt-4">
        {activeTab === 'salary' && (
          <div className="bg-white rounded-b-lg shadow-md">
            {salaryDetails.length > 0 ? (
              <div>
                {salaryDetails.map((salary) => (
                  <div key={salary.id} className="p-4 border-b border-gray-200">
                    <p className="text-gray-700">Employee ID    : {salary.employee.id}</p>
                    <p className="text-gray-700">Month-Year     : {salary.monthYear}</p>
                    <p className="text-gray-700">Base Salary    : {salary.baseSalary}</p>
                    <p className="text-gray-700">Base Allowance : {salary.allowance}</p>
                    <p className="text-gray-700">Base Deductions: {salary.deductions}</p>
                  </div>
                ))}
              </div>
            ) : (
              <p className="text-gray-700 p-4">No salary details found.</p>
            )}
          </div>
        )}
        {activeTab === 'attendance' && (
          <div>
            <AttendanceCalendar
              employeeId={id}
              allowance={salaryDetails.length > 0 ? salaryDetails[0].allowance : 0}
              baseSalary={salaryDetails.length > 0 ? salaryDetails[0].baseSalary : 0}
              deductions={salaryDetails.length > 0 ? salaryDetails[0].deductions : 0}
            />
          </div>
        )}
      </div>
    </div>
  );
};

export default EmployeeDetail;

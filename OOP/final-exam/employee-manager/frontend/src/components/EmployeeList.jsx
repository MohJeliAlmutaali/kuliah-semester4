import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import EmployeeForm from './EmployeeForm';

const EmployeeList = () => {
  const [employees, setEmployees] = useState([]);
  const [editMode, setEditMode] = useState(false);
  const [addMode, setAddMode] = useState(false);
  const [editEmployee, setEditEmployee] = useState(null);
  const [searchId, setSearchId] = useState('');
  const [searchResult, setSearchResult] = useState(null);
  const apiUrl = 'http://localhost:8080/api/employees';

  useEffect(() => {
    fetchEmployees();
  }, []);

  const fetchEmployees = async () => {
    try {
      const response = await fetch(apiUrl);
      if (response.ok) {
        const data = await response.json();
        setEmployees(data);
      } else {
        console.error('Failed to fetch employees');
      }
    } catch (error) {
      console.error('Error:', error);
    }
  };

  const handleEdit = (employee) => {
    setEditEmployee(employee);
    setEditMode(true);
    setAddMode(false);
  };

  const handleAdd = () => {
    setEditEmployee(null); // Reset editEmployee
    setEditMode(false);
    setAddMode(true);
  };

  const handleDelete = async (id) => {
    try {
      const response = await fetch(`${apiUrl}/${id}`, {
        method: 'DELETE',
      });

      if (response.ok) {
        alert('Employee deleted successfully');
        fetchEmployees();
      } else {
        alert('Failed to delete employee');
      }
    } catch (error) {
      console.error('Error:', error);
      alert('Failed to delete employee');
    }
  };

  const handleSearch = async (e) => {
    e.preventDefault();
    if (!searchId) return;

    try {
      const response = await fetch(`${apiUrl}/${searchId}`);
      if (response.ok) {
        const data = await response.json();
        setSearchResult(data);
      } else {
        alert('Employee not found');
      }
    } catch (error) {
      console.error('Error:', error);
      alert('Failed to search employee');
    }
  };

  return (
    <div className="container mx-auto p-6 bg-gray-50 min-h-screen">
      {editMode || addMode ? (
        <EmployeeForm 
          employee={editEmployee} 
          setEditMode={setEditMode} 
          setAddMode={setAddMode}
          addMode={addMode}
          fetchEmployees={fetchEmployees} 
        />
      ) : (
        <>
          <h1 className="text-3xl font-bold mb-8 text-center text-gray-800">Employee List</h1>
          <div className="mb-6 flex justify-between items-center">
            <button
              className="bg-green-500 hover:bg-green-600 text-white py-2 px-4 rounded transition duration-300 ease-in-out transform hover:scale-105"
              onClick={handleAdd}
            >
              Add Employee
            </button>
            <form onSubmit={handleSearch} className="flex items-center space-x-2">
              <input
                type="text"
                placeholder="Search by ID"
                value={searchId}
                onChange={(e) => setSearchId(e.target.value)}
                className="shadow appearance-none border rounded py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
              />
              <button
                type="submit"
                className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded transition duration-300 ease-in-out transform hover:scale-105 focus:outline-none focus:shadow-outline"
              >
                Search
              </button>
            </form>
          </div>
          <div className="overflow-x-auto shadow-lg rounded-lg">
            <table className="min-w-full bg-white border border-gray-200">
              <thead className="bg-gray-200">
                <tr>
                  {['Name', 'Address', 'Phone', 'Email', 'Position', 'Department', 'Join Date', 'Salary', 'Actions'].map((header) => (
                    <th key={header} className="py-3 px-4 text-left text-gray-700 font-medium text-sm">
                      {header}
                    </th>
                  ))}
                </tr>
              </thead>
              <tbody>
                {searchResult ? (
                  <tr key={searchResult.id} className="bg-white hover:bg-gray-100 transition duration-150">
                    <EmployeeRow employee={searchResult} handleEdit={handleEdit} handleDelete={handleDelete} />
                  </tr>
                ) : (
                  employees.map((employee, index) => (
                    <tr key={employee.id} className={index % 2 === 0 ? 'bg-gray-50 hover:bg-gray-100 transition duration-150' : 'bg-white hover:bg-gray-50 transition duration-150'}>
                      <EmployeeRow employee={employee} handleEdit={handleEdit} handleDelete={handleDelete} />
                    </tr>
                  ))
                )}
              </tbody>
            </table>
          </div>
        </>
      )}
    </div>
  );
};

const EmployeeRow = ({ employee, handleEdit, handleDelete }) => (
  <>
    <td className="py-3 px-4 border-b border-gray-200 text-sm">{employee.name}</td>
    <td className="py-3 px-4 border-b border-gray-200 text-sm">{employee.address}</td>
    <td className="py-3 px-4 border-b border-gray-200 text-sm">{employee.phone}</td>
    <td className="py-3 px-4 border-b border-gray-200 text-sm">{employee.email}</td>
    <td className="py-3 px-4 border-b border-gray-200 text-sm">{employee.position}</td>
    <td className="py-3 px-4 border-b border-gray-200 text-sm">{employee.department}</td>
    <td className="py-3 px-4 border-b border-gray-200 text-sm">{employee.joinDate}</td>
    <td className="py-3 px-4 border-b border-gray-200 text-sm">{employee.salary}</td>
    <td className="py-3 px-4 border-b border-gray-200 text-sm">
      <button
        className="bg-blue-500 hover:bg-blue-600 text-white py-1 px-3 rounded mr-2 transition duration-300 ease-in-out transform hover:scale-105"
        onClick={() => handleEdit(employee)}
      >
        Edit
      </button>
      <button
        className="bg-red-500 hover:bg-red-600 text-white py-1 px-3 rounded mr-2 transition duration-300 ease-in-out transform hover:scale-105"
        onClick={() => {
          if (window.confirm(`Are you sure you want to delete ${employee.name}?`)) {
            handleDelete(employee.id);
          }
        }}
      >
        Delete
      </button>
      <Link to={`/employee/${employee.id}`} className="bg-gray-500 hover:bg-gray-600 text-white py-1 px-3 rounded transition duration-300 ease-in-out transform hover:scale-105">
        Detail
      </Link>
    </td>
  </>
);

export default EmployeeList;

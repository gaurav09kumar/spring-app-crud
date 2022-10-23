package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.Employee;

public interface EmployeeService {
	
	Employee saveEmploye(Employee employee);
	
	List<Employee>  getAllEmployees();
	
	Employee getEmployeeBbyId(long id);
	
	Employee updateEmployee(Employee employee,long id);
	
	void deleteEmployee(long id);

}

package com.example.springapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springapp.exception.ResourceNotFoundException;
import com.example.springapp.model.Employee;
import com.example.springapp.repository.EmployeeRepository;
import com.example.springapp.service.EmployeeService;

@Service
public class EmloyeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	// Here no need to add @Autowired annotation if a bean has a single constructor
	// . Here EmployeeRepository bean
	public EmloyeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmploye(Employee employee) {

		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeBbyId(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new ResourceNotFoundException("employee", "id", id);
		}

		/**
		 * Lambda expression approach return
		 * employeerepository.findById(id).orElseThrow(() -> new
		 * ResourceNotFoundException("employee", "id", id))
		 */
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		// Step 1 : Check if employee with given id exist in DB or not
		Employee existingEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));

		// add updated details to existing employee
		existingEmployee.setFirstname(employee.getFirstname());
		existingEmployee.setLastname(employee.getLastname());
		existingEmployee.setEmail(employee.getEmail());

		// save existing employee to DB
		employeeRepository.save(existingEmployee);

		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		// check if employee exists in a db or not
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);
	}

}

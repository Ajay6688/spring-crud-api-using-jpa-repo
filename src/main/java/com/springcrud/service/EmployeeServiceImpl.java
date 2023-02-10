package com.springcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springcrud.dao.EmployeeRepository;
import com.springcrud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int empId) {

		Optional<Employee> result = employeeRepository.findById(empId);
		
		Employee employee = null ;
		
		if(result.isPresent()) {
			employee = result.get();
		}else {
//			if we did not find any employee in database 
			throw new RuntimeException("Did not find any employee id :"+empId);
		}
		
		return employee;
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
		 
	}
	
	
	@Override
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		
	}

}

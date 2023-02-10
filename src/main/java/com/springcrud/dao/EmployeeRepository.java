package com.springcrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springcrud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// crud functions findAll() , findById() , save() , deleteById() 
}

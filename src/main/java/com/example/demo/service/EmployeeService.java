package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmps();

	Employee addNewEmp(Employee e);

	Employee getEmpDetails(Long id);

	Employee updateEmp(Employee e);

	String deleteEmp(Long id);

}

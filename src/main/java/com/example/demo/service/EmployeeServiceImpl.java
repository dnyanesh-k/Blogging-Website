package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.custome_exceptions.AnyException;
import com.example.demo.entity.Employee;
import com.example.demo.reopsitory.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public List<Employee> getAllEmps(){
		
  		
		return empRepo.findAll();
		
		
	}
	
	@Override
	public Employee addNewEmp(Employee e) {
		
		return empRepo.save(e);
	}

	@Override
	public Employee getEmpDetails(Long id) {
		
		return empRepo.findById(id).orElseThrow(()->new RuntimeException("Invalid empId"));
	}

	@Override
	public Employee updateEmp(Employee e) {
		
		if(empRepo.existsById(e.getEmpId()))
		return empRepo.save(e);
		
		throw new AnyException("Invalid empId");
	}

	@Override
	public String deleteEmp(Long id) {
		
		if(empRepo.existsById(id)) {
			empRepo.deleteById(id);
		return "Employee deleted successfully!!!";
	     }
		return "deletion of emp details failed !!!";
	}
	
}

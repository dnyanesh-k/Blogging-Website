package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/emps")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	
	@GetMapping
	public List<Employee> getEmps(){
		
		return empService.getAllEmps();
	}
	
	@PostMapping
	public ResponseEntity<?> addNewEmp(@RequestBody Employee e) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(empService.addNewEmp(e));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmpDetails(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(empService.getEmpDetails(id));
	}
	
	@PutMapping
	public Employee updateEmpDetails(@RequestBody Employee e) {
		
		return empService.updateEmp(e);
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		return empService.deleteEmp(id);
	}
	
}

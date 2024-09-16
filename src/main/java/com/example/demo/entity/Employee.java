package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long empId;
	
	@Column(length = 20)
	private String firstName;
	
	@Column(length = 20)
	private String lastName;
	
	@Column(length = 20,unique = true)
	private String email;
	
	@Column(length = 20)
	private String password;
	
	@Column(length = 20)
	private String phoneNumber;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;

	private LocalDate doj;

	@Column(length = 20)
	private String dept;

	public Employee(String firstName, String lastName, String email, String password, String phoneNumber,Role role, LocalDate doj,
			String dept) {
		//super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.role=role;
		this.doj = doj;
		this.dept = dept;
	}
	
	
	
	
}

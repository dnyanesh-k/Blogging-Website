package com.example.demo.dao;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Role;
import com.example.demo.reopsitory.EmployeeRepository;

@DataJpaTest
//@AutoConfigureTestDatabase(replace=Replace.ANY)
@ActiveProfiles("test")
@Rollback(false)
public class EmployeeRepositoryTest {
	
	@Autowired
	private EmployeeRepository eRepo;
	
	@Test
	void saveEmps() {
		List<Employee> list=List.of(
				new Employee("a3","b3","a3@test.com","1234","12345",Role.ROLE_DEV,LocalDate.parse("2020-10-20"),"HR"),
				new Employee("a4","b4","a4@test.com","1234","123456",Role.ROLE_DEV,LocalDate.parse("2020-10-20"),"MKTG")
				);
		
		List<Employee> list2 = eRepo.saveAll(list);
		assertEquals(2, list2.size());
	}
	
	
	
	
	

}

package com.example.SpringBootApiCurd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootApiCurd.EmployeeService;
import com.example.SpringBootApiCurd.entity.Employee;

//200,204//not found,500//interval ser4ver error created(201)
@RestController
public class EmployeeController {

	// depent
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/smita/create")

	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {

		Employee employee2 = employeeService.careteEmployee(employee);
		return new ResponseEntity<>(employee2, HttpStatus.CREATED);// 201

	}

	@GetMapping("/smite/fetch")
	public ResponseEntity<List<Employee>> getAll() {
		
	List<Employee>list=	employeeService.getAllEmployees();
		return new ResponseEntity<>(list, HttpStatus.OK);//200
				
			
	}

	@PutMapping("/smita/update/{id}")

	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable int id) {

		return employeeService.updateEmployee(employee, id);
	}

	@DeleteMapping("/smita/delete/{id}")

	public Map<String, Boolean> delteMap(@PathVariable int id) {
		employeeService.deleteEmployee(id);

		Map<String, Boolean> map = new HashMap<String, Boolean>();

		map.put("employee is deleted", true);

		return map;
	}

}

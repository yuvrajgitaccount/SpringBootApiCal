package com.example.SpringBootApiCurd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootApiCurd.dao.EmployeeDao;
import com.example.SpringBootApiCurd.entity.Employee;

@Service
public class EmployeeService {

	// depended

	@Autowired
	private EmployeeDao employeeDao;

	// carete Employee

	public Employee careteEmployee(Employee employee) {

		return employeeDao.save(employee);
	}

	// fetch all

	public List<Employee> getAllEmployees() {
		return employeeDao.findAll();
	}

	// update

	public Employee updateEmployee(Employee employee2, int id) {
		Employee employee = employeeDao.findById(id).get();

		employee.setName(employee2.getName());
		employee.setEmail(employee2.getEmail());
		employee.setAdress(employee2.getAdress());

		return employeeDao.save(employee);
	}
	
	//delete
	
	public void deleteEmployee(int id)
	{
		Employee employee = employeeDao.findById(id).get();
		
		  employeeDao.delete(employee);
	}
}

package com.project.supermarketapi.repository.custom;

import java.util.List;
import com.project.supermarketapi.model.Employee;

public interface EmployeeCustomRepository {
	Employee createEmployee(Employee paramEmployee);
	Employee updateEmployee(Employee paramEmployee);
	List<Employee> findAll();
	Employee findById(int paramInt);
	Employee deleteById(int paramInt);
}
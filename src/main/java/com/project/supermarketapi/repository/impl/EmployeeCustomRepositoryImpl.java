package com.project.supermarketapi.repository.impl;
 
 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.supermarketapi.model.Employee;
import com.project.supermarketapi.repository.EmployeeRepository;
import com.project.supermarketapi.repository.custom.EmployeeCustomRepository;

 @Service
 public class EmployeeCustomRepositoryImpl implements EmployeeCustomRepository {
   @Autowired
   EmployeeRepository employeeRepo;
   
   public Employee createEmployee(Employee employee) {
     return employeeRepo.save(employee);
   }
   
   public Employee updateEmployee(Employee employee) {
     Employee e = employeeRepo.findById(employee.getEmployeeId());
     if (e == null)
       return null;
     if (employee.getFirstName() != null)
       e.setFirstName(employee.getFirstName()); 
     if (employee.getLastName() != null || employee.getFirstName() == null)
       return null;
     return (employeeRepo.save(e));
   }
   
   public List<Employee> findAll() {
     return employeeRepo.findAll();
   }
   
   public Employee findById(int id) {
     Employee e = employeeRepo.findById(id);
     if (e == null)
       return null;
     return e;
   }
   
   public Employee deleteById(int id) {
     Employee e = employeeRepo.findById(id);
     if (e == null)
       return null;
     employeeRepo.deleteById(Integer.valueOf(id));
     if (employeeRepo.findById(id) != null)
       return null;
     return (e);
   }
 }
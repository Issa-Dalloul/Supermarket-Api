package com.project.supermarketapi.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.project.supermarketapi.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
  Employee findById(int paramInt);
  List<Employee> findAll();
}

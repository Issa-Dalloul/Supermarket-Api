package com.project.supermarketapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.supermarketapi.model.Employee;
import com.project.supermarketapi.model.Response;
import com.project.supermarketapi.model.ResponseBuilder;
import com.project.supermarketapi.repository.custom.EmployeeCustomRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeCustomRepository employeeRepo;


    @PostMapping
    public Response createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeRepo.createEmployee(employee);
        return ResponseBuilder.success(createdEmployee);
    }

    @PatchMapping("/{id}")
    public Response updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employee.setEmployeeId(id);
        Employee updatedEmployee = employeeRepo.updateEmployee(employee);
        if (updatedEmployee != null) {
            return ResponseBuilder.success(updatedEmployee);
        } else {
            return ResponseBuilder.failed();
        }
    }

    @DeleteMapping("/{id}")
    public Response deleteEmployee(@PathVariable int id) {
        Employee deletedEmployee = employeeRepo.deleteById(id);
        if (deletedEmployee != null) {
            return ResponseBuilder.success(deletedEmployee);
        } else {
            return ResponseBuilder.failed();
        }
    }

    @GetMapping
    public Response getAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        return ResponseBuilder.success(employees);
    }

    @GetMapping("/{id}")
    public Response getEmployeeById(@PathVariable int id) {
        Employee employee = employeeRepo.findById(id);
        if (employee != null) {
            return ResponseBuilder.success(employee);
        } else {
            return ResponseBuilder.failed();
        }
    }
}

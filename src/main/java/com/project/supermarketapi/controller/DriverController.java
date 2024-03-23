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

import com.project.supermarketapi.model.Driver;
import com.project.supermarketapi.model.Response;
import com.project.supermarketapi.model.ResponseBuilder;
import com.project.supermarketapi.repository.custom.DriverCustomRepository;

@RestController
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    private DriverCustomRepository driverRepo;

    @PostMapping
    public Response createDriver(@RequestBody Driver driver) {
        Driver createdDriver = driverRepo.createDriver(driver);
        return ResponseBuilder.success(createdDriver);
    }

    @PatchMapping("/{id}")
    public Response updateDriver(@PathVariable int id, @RequestBody Driver driver) {
        driver.setDriverId(id);
        Driver updatedDriver = driverRepo.updateDriver(driver);
        if (updatedDriver != null) {
            return ResponseBuilder.success(updatedDriver);
        } else {
            return ResponseBuilder.failed();
        }
    }

    @DeleteMapping("/{id}")
    public Response deleteDriver(@PathVariable int id) {
        Driver deletedDriver = driverRepo.deleteById(id);
        if (deletedDriver != null) {
            return ResponseBuilder.success(deletedDriver);
        } else {
            return ResponseBuilder.failed();
        }
    }

    @GetMapping
    public Response getAllDrivers() {
        List<Driver> drivers = driverRepo.findAll();
        return ResponseBuilder.success(drivers);
    }

    @GetMapping("/{id}")
    public Response getDriverById(@PathVariable int id) {
        Driver driver = driverRepo.findById(id);
        if (driver != null) {
            return ResponseBuilder.success(driver);
        } else {
            return ResponseBuilder.failed();
        }
    }
}

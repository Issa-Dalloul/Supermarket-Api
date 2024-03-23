package com.project.supermarketapi.repository.impl;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.supermarketapi.model.Driver;
import com.project.supermarketapi.repository.DriverRepository;
import com.project.supermarketapi.repository.custom.DriverCustomRepository;
 
 @Service
 public class DriverCustomRepositoryImpl implements DriverCustomRepository {
   @Autowired
   DriverRepository driverRepo;
   
   public Driver createDriver(Driver driver) {
     return driverRepo.save(driver);
   }
   
   public Driver updateDriver(Driver driver) {
     Driver d = driverRepo.findById(driver.getDriverId());
     if (d == null)
       return null;
     if (driver.getDriverName() != null) {
       d.setDriverName(driver.getDriverName());
     } else if (driver.getSupplier() != null || driver.getDriverName() == null) {
       return null;
     } 
     return driverRepo.save(d);
   }
   
   public Driver deleteById(int id) {
     Driver d = driverRepo.findById(id);
     driverRepo.deleteById(Integer.valueOf(id));
     if (driverRepo.findById(id) != null)
       return null; 
     return d;
   }
   
   public List<Driver> findAll() {
     return driverRepo.findAll();
   }
   
   public Driver findById(int id) {
	   return driverRepo.findById(id);
   }
 }
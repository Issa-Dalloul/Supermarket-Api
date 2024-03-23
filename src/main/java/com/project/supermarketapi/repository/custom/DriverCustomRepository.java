package com.project.supermarketapi.repository.custom;
import java.util.List;

import com.project.supermarketapi.model.Driver;
 
public interface DriverCustomRepository {
	Driver createDriver(Driver paramDriver);
	Driver updateDriver(Driver paramDriver);
	Driver deleteById(int paramInt);
	List<Driver> findAll();
	Driver findById(int paramInt);
}

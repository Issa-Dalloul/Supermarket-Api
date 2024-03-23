package com.project.supermarketapi.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.project.supermarketapi.model.Driver;

public interface DriverRepository extends CrudRepository<Driver, Integer> {
  Driver findById(int paramInt);
  List<Driver> findAll();
}

package com.project.supermarketapi.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.project.supermarketapi.model.Purchase;

public interface PurchaseRepository extends CrudRepository<Purchase, Integer> {
  Purchase findById(int paramInt);
  List<Purchase> findAll();
}

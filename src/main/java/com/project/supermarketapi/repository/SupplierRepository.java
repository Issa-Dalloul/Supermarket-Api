package com.project.supermarketapi.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.project.supermarketapi.model.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier, Integer> {
  Supplier findById(int paramInt);
  List<Supplier> findAll();
}


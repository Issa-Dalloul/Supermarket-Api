package com.project.supermarketapi.repository.custom;

import java.util.List;

import com.project.supermarketapi.model.Supplier;

public interface SupplierCustomRepository {
	Supplier createSupplier(Supplier paramSupplier);
    Supplier updateSupplier(Supplier paramSupplier);
    Supplier deleteById(int paramInt);
    List<Supplier> findAll();
    Supplier findById(int paramInt);
}

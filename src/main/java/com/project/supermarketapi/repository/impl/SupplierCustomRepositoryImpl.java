package com.project.supermarketapi.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.supermarketapi.model.Driver;
import com.project.supermarketapi.model.Supplier;
import com.project.supermarketapi.repository.DriverRepository;
import com.project.supermarketapi.repository.SupplierRepository;
import com.project.supermarketapi.repository.custom.SupplierCustomRepository;

@Service
public class SupplierCustomRepositoryImpl implements SupplierCustomRepository {
	@Autowired
	SupplierRepository supplierRepo;

	@Autowired
	DriverRepository driverRepo;

	public Supplier createSupplier(Supplier supplier) {
		Driver d = supplier.getDriver();
		if (d == null)
			return null;
		d = driverRepo.findById(d.getDriverId());
		if (d == null)
			return null;
		supplier.setDriver(d);
		return supplierRepo.save(supplier);
	}

	public Supplier updateSupplier(Supplier supplier) {
		Supplier s = supplierRepo.findById(supplier.getSupplierId());
		if (s == null)
			return null;
		if (supplier.getSupplierName() != null)
			return null;
		if (supplier.getDriver() != null) {
			int id = supplier.getDriver().getDriverId();
			Driver d = driverRepo.findById(id);
			if (d == null)
				return null;
			s.setDriver(d);
			s = (Supplier) supplierRepo.save(s);
			if (s.getDriver() != d)
				return null;
			return (s);
		}
		return null;
	}

	public Supplier deleteById(int id) {
		Supplier s = supplierRepo.findById(id);
		supplierRepo.deleteById(id);
		if (supplierRepo.findById(id) != null)
			return null;
		return s;
	}

	public List<Supplier> findAll() {
		return supplierRepo.findAll();
	}

	public Supplier findById(int id) {
		return supplierRepo.findById(id);
	}
}

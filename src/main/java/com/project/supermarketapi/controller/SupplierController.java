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

import com.project.supermarketapi.model.Response;
import com.project.supermarketapi.model.ResponseBuilder;
import com.project.supermarketapi.model.Supplier;
import com.project.supermarketapi.repository.custom.SupplierCustomRepository;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private SupplierCustomRepository supplierRepository;

	@PostMapping
	public Response createSupplier(@RequestBody Supplier supplier) {
		Supplier createdSupplier = supplierRepository.createSupplier(supplier);
		if (createdSupplier != null) {
			return ResponseBuilder.success(createdSupplier);
		} else {
			return ResponseBuilder.failed();
		}
	}

	@PatchMapping("/{id}")
	public Response updateSupplier(@PathVariable int id, @RequestBody Supplier supplier) {
		Supplier updatedSupplier = supplierRepository.updateSupplier(supplier);
		if (updatedSupplier != null) {
			return ResponseBuilder.success(updatedSupplier);
		} else {
			return ResponseBuilder.failed();
		}
	}

	@DeleteMapping("/{id}")
	public Response deleteSupplier(@PathVariable int id) {
		Supplier deletedSupplier = supplierRepository.deleteById(id);
		if (deletedSupplier != null) {
			return ResponseBuilder.success(deletedSupplier);
		} else {
			return ResponseBuilder.failed();
		}
	}

	@GetMapping
	public Response getAllSuppliers() {
		List<Supplier> suppliers = supplierRepository.findAll();
		return ResponseBuilder.success(suppliers);
	}

	@GetMapping("/{id}")
	public Response getSupplierById(@PathVariable int id) {
		Supplier supplier = supplierRepository.findById(id);
		if (supplier != null) {
			return ResponseBuilder.success(supplier);
		} else {
			return ResponseBuilder.failed();
		}
	}
}

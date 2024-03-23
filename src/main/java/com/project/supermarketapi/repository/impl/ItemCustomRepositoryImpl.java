package com.project.supermarketapi.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.supermarketapi.model.Item;
import com.project.supermarketapi.model.Supplier;
import com.project.supermarketapi.repository.ItemRepository;
import com.project.supermarketapi.repository.SupplierRepository;
import com.project.supermarketapi.repository.custom.ItemCustomRepository;

@Service
public class ItemCustomRepositoryImpl implements ItemCustomRepository {
	@Autowired
	ItemRepository itemRepo;

	@Autowired
	SupplierRepository supplierRepo;

	public Item createItem(Item item) {
		Supplier s = item.getSupplier();
		if (s == null)
			return null;
		s = supplierRepo.findById(s.getSupplierId());
		if (s == null)
			return null;
		item.setSupplier(s);
		return (itemRepo.save(item));
	}

	public Item updateItem(Item item) {
		Item d = itemRepo.findById(item.getItemId());
		if (d == null)
			return null;
		if (item.getItemPrice() != 0.0D)
			d.setItemPrice(item.getItemPrice());
		if (item.getItemStock() != 0.0D)
			d.setItemStock(item.getItemStock());
		if (item.getItemPrice() == 0.0D && item.getItemStock() == 0.0D)
			return null;
		if (item.getSupplier() != null || item.getItemName() != null)
			return null;
		return (itemRepo.save(d));
	}

	public Item deleteById(int id) {
		Item d = itemRepo.findById(id);
		if (d == null)
			return null;
		itemRepo.deleteById(Integer.valueOf(id));
		if (itemRepo.findById(id) != null)
			return null;
		return d;
	}

	public List<Item> findAll() {
		return itemRepo.findAll();
	}

	public Item findById(int id) {
		return itemRepo.findById(id);
	}
}

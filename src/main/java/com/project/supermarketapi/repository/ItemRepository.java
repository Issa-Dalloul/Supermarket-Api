package com.project.supermarketapi.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.project.supermarketapi.model.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {
  Item findById(int paramInt);  
  List<Item> findAll();
}

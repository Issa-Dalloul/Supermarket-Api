package com.project.supermarketapi.repository.custom;

import java.util.List;

import com.project.supermarketapi.model.Item;

public interface ItemCustomRepository {
  Item createItem(Item paramItem);
  Item updateItem(Item paramItem);
  Item deleteById(int paramInt);
  List<Item> findAll();
  Item findById(int paramInt);
}

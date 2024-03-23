package com.project.supermarketapi.repository.custom;

import java.util.List;
import com.project.supermarketapi.model.Purchase;

public interface PurchaseCustomRepository {
  Purchase createPurchase(Purchase paramPurchase);
  Purchase updatePurchase(Purchase paramPurchase);
  Purchase deleteById(int paramInt);
  List<Purchase> findAll();
  Purchase findById(int paramInt);
}
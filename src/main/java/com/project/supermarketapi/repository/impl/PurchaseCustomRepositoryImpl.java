package com.project.supermarketapi.repository.impl;
 import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.supermarketapi.model.Client;
import com.project.supermarketapi.model.Employee;
import com.project.supermarketapi.model.Item;
import com.project.supermarketapi.model.Purchase;
import com.project.supermarketapi.repository.ClientRepository;
import com.project.supermarketapi.repository.EmployeeRepository;
import com.project.supermarketapi.repository.ItemRepository;
import com.project.supermarketapi.repository.PurchaseRepository;
import com.project.supermarketapi.repository.custom.PurchaseCustomRepository;
 
 @Service
 public class PurchaseCustomRepositoryImpl implements PurchaseCustomRepository {
   @Autowired
   PurchaseRepository purchaseRepo;
   
   @Autowired
   EmployeeRepository employeeRepo;
   
   @Autowired
   ClientRepository clientRepo;
   
   @Autowired
   ItemRepository itemRepo;
   
   public Purchase createPurchase(Purchase purchase) {
     Client c = purchase.getClient();
     Employee e = purchase.getEmployee();
     List<Item> items = purchase.getItems();
     if (c == null || e == null || items == null) return null;

     e = employeeRepo.findById(e.getEmployeeId());
     c = clientRepo.findById(c.getClientId());
     for (int i = 0; i < items.size(); i++) {
       Item item = items.get(i);
       int id = item.getItemId();
       item = itemRepo.findById(id);
       if (item == null)
         return null; 
       items.set(i, item);
     } 
     if (e == null || c == null) return null;
   	 purchase.setEmployee(e);
     purchase.setClient(c);
     purchase.setItems(items);
     purchase.setDate(LocalDateTime.now());
     return (purchaseRepo.save(purchase));
   }
   
   public Purchase updatePurchase(Purchase purchase) {
     Purchase p = purchaseRepo.findById(purchase.getPurchaseId());
     if (p == null)
       return null;
     if (purchase.getTotalPrice() != 0.0D)
       purchase.setTotalPrice(purchase.getTotalPrice()); 
     if (purchase.getClient() != null || purchase.getEmployee() != null || purchase
       .getDate() != null || purchase.getItems() != null || purchase
       .getTotalPrice() == 0.0D)
       return null; 
     return purchaseRepo.save(p);
   }
   
   public Purchase deleteById(int id) {
     Purchase d = purchaseRepo.findById(id);
     if (d == null)
       return null; 
     purchaseRepo.deleteById(Integer.valueOf(id));
     if (purchaseRepo.findById(id) != null)
       return null; 
     return d;
   }
   
   public List<Purchase> findAll() {
     return purchaseRepo.findAll();
   }
   
   public Purchase findById(int id) {
     return purchaseRepo.findById(id);
   }
 }

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

import com.project.supermarketapi.model.Purchase;
import com.project.supermarketapi.model.Response;
import com.project.supermarketapi.model.ResponseBuilder;
import com.project.supermarketapi.repository.custom.PurchaseCustomRepository;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseCustomRepository purchaseRepo;

    @PostMapping
    public Response createPurchase(@RequestBody Purchase purchase) {
        Purchase createdPurchase = purchaseRepo.createPurchase(purchase);
        if (createdPurchase != null) {
            return ResponseBuilder.success(createdPurchase);
        } else {
            return ResponseBuilder.failed();
        }
    }

    @PatchMapping("/{id}")
    public Response updatePurchase(@PathVariable int id, @RequestBody Purchase purchase) {
        Purchase updatedPurchase = purchaseRepo.updatePurchase(purchase);
        if (updatedPurchase != null) {
            return ResponseBuilder.success(updatedPurchase);
        } else {
            return ResponseBuilder.failed();
        }
    }

    @DeleteMapping("/{id}")
    public Response deletePurchase(@PathVariable int id) {
        Purchase deletedPurchase = purchaseRepo.deleteById(id);
        if (deletedPurchase != null) {
            return ResponseBuilder.success(deletedPurchase);
        } else {
            return ResponseBuilder.failed();
        }
    }

    @GetMapping
    public Response getAllPurchases() {
        List<Purchase> purchases = purchaseRepo.findAll();
        return ResponseBuilder.success(purchases);
    }

    @GetMapping("/{id}")
    public Response getPurchaseById(@PathVariable int id) {
        Purchase purchase = purchaseRepo.findById(id);
        if (purchase != null) {
            return ResponseBuilder.success(purchase);
        } else {
            return ResponseBuilder.failed();
        }
    }
}

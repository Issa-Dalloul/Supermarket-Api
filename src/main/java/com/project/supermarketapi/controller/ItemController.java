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

import com.project.supermarketapi.model.Item;
import com.project.supermarketapi.model.Response;
import com.project.supermarketapi.model.ResponseBuilder;
import com.project.supermarketapi.repository.custom.ItemCustomRepository;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemCustomRepository itemRepo;

    @PostMapping
    public Response createItem(@RequestBody Item item) {
        Item createdItem = itemRepo.createItem(item);
        if (createdItem != null) {
            return ResponseBuilder.success(createdItem);
        } else {
            return ResponseBuilder.failed();
        }
    }

    @PatchMapping("/{id}")
    public Response updateItem(@PathVariable int id, @RequestBody Item item) {
        item.setItemId(id);
        Item updatedItem = itemRepo.updateItem(item);
        if (updatedItem != null) {
            return ResponseBuilder.success(updatedItem);
        } else {
            return ResponseBuilder.failed();
        }
    }

    @DeleteMapping("/{id}")
    public Response deleteItem(@PathVariable int id) {
        Item deletedItem = itemRepo.deleteById(id);
        if (deletedItem != null) {
            return ResponseBuilder.success(deletedItem);
        } else {
            return ResponseBuilder.failed();
        }
    }

    @GetMapping
    public Response getAllItems() {
        List<Item> items = itemRepo.findAll();
        return ResponseBuilder.success(items);
    }

    @GetMapping("/{id}")
    public Response getItemById(@PathVariable int id) {
        Item item = itemRepo.findById(id);
        if (item != null) {
            return ResponseBuilder.success(item);
        } else {
            return ResponseBuilder.failed();
        }
    }
}

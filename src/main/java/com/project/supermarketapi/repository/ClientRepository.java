package com.project.supermarketapi.repository;

import java.util.List; 
import org.springframework.data.repository.CrudRepository;
import com.project.supermarketapi.model.Client;

public interface ClientRepository extends CrudRepository<Client, Integer> {
  List<Client> findAll();
  Client findById(int paramInt);
}

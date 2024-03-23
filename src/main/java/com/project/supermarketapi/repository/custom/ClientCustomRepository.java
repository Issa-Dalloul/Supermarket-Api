package com.project.supermarketapi.repository.custom;
import java.util.List;

import com.project.supermarketapi.model.Client;

public interface ClientCustomRepository {
	Client createClient(Client paramClient);
	Client updateClient(Client paramClient);
  	Client deleteById(int paramInt);
  	List<Client> findAll();
  	Client findById(int paramInt);
}

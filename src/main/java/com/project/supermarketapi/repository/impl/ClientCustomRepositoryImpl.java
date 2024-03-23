package com.project.supermarketapi.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.supermarketapi.model.Client;
import com.project.supermarketapi.repository.ClientRepository;
import com.project.supermarketapi.repository.custom.ClientCustomRepository;

@Service
public class ClientCustomRepositoryImpl implements ClientCustomRepository {
    @Autowired
    ClientRepository clientRepo;
    public Client createClient(Client client) {
        return clientRepo.save(client);
    }

    public Client updateClient(Client client) {
        Client c = clientRepo.findById(client.getClientId());
        if (c == null)
            return null;
        if (client.getFirstName() != null)
            c.setFirstName(client.getFirstName());
        if (client.getLastName() != null)
            c.setLastName(client.getLastName());
        if (client.getEmail() != null)
            c.setEmail(client.getEmail());
        return clientRepo.save(c);
    }

    public Client deleteById(int id) {
        Client c = clientRepo.findById(id);
        clientRepo.deleteById(id);
        if (clientRepo.findById(id) == null)
            return c;
        return null;
    }

    public List<Client> findAll() {
        return clientRepo.findAll();
    }

    public Client findById(int id) {
        return clientRepo.findById(id);
    }
}

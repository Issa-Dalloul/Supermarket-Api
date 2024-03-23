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

import com.project.supermarketapi.model.Client;
import com.project.supermarketapi.model.Response;
import com.project.supermarketapi.model.ResponseBuilder;
import com.project.supermarketapi.repository.custom.ClientCustomRepository;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
    private ClientCustomRepository clientRepo;


    @PostMapping
    public Response createClient(@RequestBody Client client) {
        Client createdClient = clientRepo.createClient(client);
        if (createdClient != null) {
            return ResponseBuilder.success(client);
        } else {
            return ResponseBuilder.failed();

        }
    }

    @PatchMapping("/{id}")
    public Response updateClient(@PathVariable int id, @RequestBody Client client) {
        client.setClientId(id);
        Client updatedClient = clientRepo.updateClient(client);
        if (updatedClient != null) {
            return ResponseBuilder.success(updatedClient);
        } else {
            return ResponseBuilder.failed();
        }
    }

    @DeleteMapping("/{id}")
    public Response deleteClient(@PathVariable int id) {
        Client deletedClient = clientRepo.deleteById(id);
        if (deletedClient != null) {
            return ResponseBuilder.success(deletedClient);
        } else {
            return ResponseBuilder.failed();
        }
    }

    @GetMapping
    public Response getAllClients() {
        List<Client> clients = clientRepo.findAll();
        return ResponseBuilder.success(clients);
    }

    @GetMapping("/{id}")
    public Response getClientById(@PathVariable int id) {
        Client client = clientRepo.findById(id);
        if (client != null) {
        	return ResponseBuilder.success(client);
        } else {
        	return ResponseBuilder.failed();
        }
    }
}

package com.commandespringboot.services;

import com.commandespringboot.models.Client;
import com.commandespringboot.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client saveClient(Client c){
        return clientRepository.save(c);
    }
}

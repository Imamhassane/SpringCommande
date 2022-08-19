package com.commandespringboot.controllers;

import com.commandespringboot.models.Adresse;
import com.commandespringboot.models.Client;
import com.commandespringboot.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/client")
public class ClientController {

    @Autowired
    private ClientService clientService;
    @GetMapping("/new")
    public String showForm(){
        return "client/add";
    }

    @RequestMapping(value = "/saveUser" , method = RequestMethod.POST)
    public String saveNewClient(@ModelAttribute("client") Client client , @ModelAttribute("adresse") Adresse adresse){
        System.out.print(client.getAdresse());
        Client c = new Client();
        Adresse a = new Adresse();

        a.setQuartier(adresse.getQuartier());
        a.setVille(adresse.getVille());

        client.setAdresse(a);
        client.setNumero(client.getNumero());
        client.setNom(client.getNom());
        client.setPassword(client.getPassword());
        client.setPrenom(client.getPrenom());
        client.setEmail(client.getEmail());

        clientService.saveClient(client);
        return "redirect:/connexion";
    }
}

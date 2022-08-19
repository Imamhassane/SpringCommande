package com.commandespringboot.services;

import com.commandespringboot.models.Boisson;
import com.commandespringboot.models.Complement;
import com.commandespringboot.models.Taille;
import com.commandespringboot.repository.BoissonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoissonService {
    @Autowired
    private BoissonRepository boissonRepository;
    public Complement saveBoisson (Boisson complement){
        return boissonRepository.save(complement);
    }
    public List<Boisson> listAll(){
        return boissonRepository.findAll();
    }
    public Optional<Boisson> getById(Long id){
        return boissonRepository.findById(id);
    }
    public List<Boisson> getByTaille(Taille taille){
        return boissonRepository.findBoissonByTaille(taille);
    }
}

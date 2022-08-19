package com.commandespringboot.services;


import com.commandespringboot.models.Marque;
import com.commandespringboot.repository.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarqueService {
    @Autowired
    private MarqueRepository marqueRepository;
    public Marque saveMarque (Marque marque){
        return marqueRepository.save(marque);
    }
    public List<Marque> listAll(){
        return marqueRepository.findAll();
    }
    public Optional<Marque> getById(Long id){
        return marqueRepository.findById(id);
    }

}

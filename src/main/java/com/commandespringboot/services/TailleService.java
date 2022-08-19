package com.commandespringboot.services;

import com.commandespringboot.models.Taille;
import com.commandespringboot.repository.TailleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TailleService {
    @Autowired
    private TailleRepository tailleRepository;

    public List<Taille> listAll(){
        return tailleRepository.findAll();
    }
    
    public Optional<Taille> findbyid(Long id){
        return  tailleRepository.findById(id);
    }
    public Taille saveTaille(Taille t){
        return tailleRepository.saveAndFlush(t);
    }
    public List<Taille> getTaillesbyType(String type){
        return tailleRepository.findByType(type);
    }
}

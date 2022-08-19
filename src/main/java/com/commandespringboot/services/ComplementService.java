package com.commandespringboot.services;

import com.commandespringboot.models.Boisson;
import com.commandespringboot.models.Burger;
import com.commandespringboot.models.Complement;
import com.commandespringboot.models.Taille;
import com.commandespringboot.repository.BurgerRepository;
import com.commandespringboot.repository.ComplementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComplementService {
    @Autowired
    private ComplementRepository complementRepository;
    public Complement saveComplement (Complement complement){
        return complementRepository.save(complement);
    }
    public List<Complement> listAll(){
        return complementRepository.findAll();
    }
    public Optional<Complement> getById(Long id){
        return complementRepository.findById(id);
    }
    public List<Complement> getComplementByTaille(Taille taille){
        return complementRepository.findComplementByTaille(taille);
    }

}

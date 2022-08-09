package com.commandespringboot.services;

import com.commandespringboot.models.Burger;
import com.commandespringboot.repository.BurgerRepository;
import com.commandespringboot.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BurgerService {

    @Autowired
    private BurgerRepository burgerRepository;
    public Burger saveBurger (Burger burger){
        return burgerRepository.save(burger);
    }
    public List<Burger> listAll(){
        return burgerRepository.findAll();
    }
}

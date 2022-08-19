package com.commandespringboot.services;

import com.commandespringboot.models.Burger;
import com.commandespringboot.models.Menu;
import com.commandespringboot.models.QuantityEntity;
import com.commandespringboot.repository.QuantiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuantiteService {

    @Autowired
    private QuantiteRepository quantiteRepository;
    public QuantityEntity saveQuantite (QuantityEntity qe){
        return quantiteRepository.save(qe);
    }
    public List<QuantityEntity> findQByMenu (Menu menu){
        return quantiteRepository.findAllByMenu(menu);
    }
    public QuantityEntity getQuantiteEntityByBurger(Burger burger){
        return quantiteRepository.findQuantityEntityByBurger(burger);
    }

}

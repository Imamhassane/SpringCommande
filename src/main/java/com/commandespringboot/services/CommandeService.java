package com.commandespringboot.services;

import com.commandespringboot.models.Burger;
import com.commandespringboot.models.QuantityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private QuantiteService quantiteService;


}

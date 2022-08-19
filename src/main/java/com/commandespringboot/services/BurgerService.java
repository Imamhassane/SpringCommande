package com.commandespringboot.services;

import com.commandespringboot.models.Burger;
import com.commandespringboot.models.Image;
import com.commandespringboot.models.ProduitAttributes;
import com.commandespringboot.repository.BurgerRepository;
import com.commandespringboot.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class BurgerService {

    @Autowired
    private BurgerRepository burgerRepository;
    @Autowired
    private ImageService imageService;
    @Autowired
    private ImageRepository imageRepository;


   /* @PostConstruct
    public void initDB(){
        *//*Image img = imageRepository.save(new Image("about4.png"));*//*
        List<Burger> burgers = IntStream.rangeClosed(1,50)
                .mapToObj(i -> new Burger(new ProduitAttributes("Cheese" , 1500),"Ma desciption" ))
                .collect(Collectors.toList());
        burgerRepository.saveAll(burgers);
    }*/

    public Burger saveBurger (Burger burger){
        return burgerRepository.save(burger);
    }
    public List<Burger> listAll(){
        return burgerRepository.findAll();
    }
    public Optional<Burger> getById(Long id){
        return burgerRepository.findById(id);
    }

    public Object listTopTen() {
        Pageable limit = PageRequest.of(0,10);
        return burgerRepository.findAll(limit);
    }
    public Object listTopTrois() {
        Pageable limit = PageRequest.of(0,3);
        return burgerRepository.findAll(limit);
    }
    /*public List<Burger> findAllByID(List) {
        return burgerRepository.findAll(limit);
    }*/
}

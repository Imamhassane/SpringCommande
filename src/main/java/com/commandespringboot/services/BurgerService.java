package com.commandespringboot.services;

import com.commandespringboot.models.Burger;
import com.commandespringboot.models.Image;
import com.commandespringboot.repository.BurgerRepository;
import com.commandespringboot.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class BurgerService {

    @Autowired
    private BurgerRepository burgerRepository;

    @Autowired
    private ImageRepository imageRepository;

    public void saveBurger (MultipartFile file , String nom ,int prix){
        Image img = new Image();
        Burger burger = new Burger();

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")){
            System.out.println("invalid");
        }
        try {
            img.setNom(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        burger.setNom(nom);
        burger.setPrix(prix);
       /* burger.setImage(img);*/

        imageRepository.save(img);
        burgerRepository.save(burger);
    }
}

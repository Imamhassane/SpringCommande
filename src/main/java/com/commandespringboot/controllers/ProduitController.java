package com.commandespringboot.controllers;

import com.commandespringboot.models.Burger;
import com.commandespringboot.models.Image;
import com.commandespringboot.repository.ImageRepository;
import com.commandespringboot.services.BurgerService;
import com.commandespringboot.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Controller
public class ProduitController {

    @Autowired
    private BurgerService burgerService;
    @Autowired
    private ImageRepository imageRepository;
    @GetMapping("/produit/add")
    public String Viewadd(){

        return "produit/add";
    }



    @RequestMapping(value = "/produit/save" , method= RequestMethod.POST)
    public String addBurger(@RequestParam("nom") String nom , @RequestParam("prix") int prix , @RequestParam("image")MultipartFile file) throws IOException {
        Burger burger = new Burger();
        burger.setNom(nom);
        burger.setPrix(prix);
        Burger burgerSaved = burgerService.saveBurger(burger);
            Image image = new Image();
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            image.setNom(fileName);
            image.setBurger(burgerSaved);
            Image imgSaved = imageRepository.save(image);
            String uploadDir = "upload/" + imgSaved.getId();
            ImageService.saveFile(uploadDir, fileName, file);


        return "redirect:/produit/list";
    }


    @GetMapping("/produit/list")
    public String list(Model model){
        model.addAttribute("burgers" , burgerService.listAll());
        return  "produit/list";
    }
}

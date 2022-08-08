package com.commandespringboot.controllers;

import com.commandespringboot.services.BurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class ProduitController {

    @Autowired
    private BurgerService burgerService;

    @GetMapping("/produit/add")
    public String Viewadd(){

        return "produit/add";
    }



    @RequestMapping(value = "/produit/save" , method= RequestMethod.POST)
    public String add(@RequestParam("nom") String nom , @RequestParam("prix") int prix , @RequestParam("image")MultipartFile files){

        return "redirect:/produit/list";
    }

    @GetMapping("/produit/list")
    public String list(){
        return  "produit/list";
    }
}

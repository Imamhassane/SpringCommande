package com.commandespringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProduitController {
    @GetMapping("/produit/add")
    public String add(){
        return "produit/add";
    }

    @GetMapping("/produit/list")
    public String list(){
        return  "produit/list";
    }
}

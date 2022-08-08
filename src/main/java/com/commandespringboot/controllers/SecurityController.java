package com.commandespringboot.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/")
    public String home(){
        return "catalogue/catalogue";
    }

    @GetMapping("/user")
    public String user(){
        return ("<h1>Bienvenue User</h1>");
    }

    @GetMapping("/admin")
    public String admin(){
        return ("<h1>Bienvenue Admin</h1>");
    }

    @GetMapping("/connexion")
    public String connexion(){
        return "security/connexion";
    }
}

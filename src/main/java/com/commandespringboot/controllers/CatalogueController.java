package com.commandespringboot.controllers;

import com.commandespringboot.models.*;
import com.commandespringboot.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CatalogueController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private BurgerService burgerService;
    @Autowired
    private BoissonService boissonService;
    @Autowired
    private QuantiteService quantiteService;
    @Autowired
    private CommandeService commandeService;
    @Autowired
    private ComplementService complementService;
    private List <Burger> burgers = new ArrayList<>();
    private List <QuantityEntity> quantityEntities = new ArrayList<>();

    @GetMapping({"/" , "/catalogue"})
    public String home(Model model){
        model.addAttribute("burgers" , burgerService.listAll());
        model.addAttribute("menus" , menuService.listAll());
        model.addAttribute("slideBurger" , burgerService.listTopTrois());

        return "catalogue/catalogue";
    }

    @GetMapping("/produit/{type}/details/{id}")
    public String detailsProduit(Model model,
                                 @PathVariable(value="id") Long id,
                                 @PathVariable(value="type") String type){

        if (type.contains("Burger")){
            Optional<Burger> burgerOptional = burgerService.getById(id);
            model.addAttribute("produit" , burgerOptional.get());
            model.addAttribute("produitList" , burgerService.listTopTen());
        }else if (type.contains("Menu")){
            List<Burger> burgerList = new ArrayList<>();
            Optional<Menu> menuOptional = menuService.getById(id);
            Menu menu =  menuOptional.get();
            List<QuantityEntity> quantityEntityList = quantiteService.findQByMenu(menu);
            for (QuantityEntity qe : quantityEntityList ){
                if (qe.getBurger() != null ){
                    burgerList.add(qe.getBurger());
                }
                if (qe.getTaille() != null){
                    if (qe.getTaille().getType().contains("FRITTES")){
                        if (qe.getTaille().getProduitAttributes().getNom().contains("frittes simple")){
                            model.addAttribute("FrittesSimpleMenu" , complementService.getComplementByTaille(qe.getTaille()));
                        }
                        if (qe.getTaille().getProduitAttributes().getNom().contains("frittes double")){
                            model.addAttribute("FrittesDoubleMenu" , complementService.getComplementByTaille(qe.getTaille()));
                        }
                        if (qe.getTaille().getProduitAttributes().getNom().contains("frittes mixte")){
                            model.addAttribute("FrittesMixteMenu" , complementService.getComplementByTaille(qe.getTaille()));
                        }
                    }
                    if (qe.getTaille().getType().contains("BOISSON")){
                        if (qe.getTaille().getProduitAttributes().getNom().contains("cannette")){
                            model.addAttribute("cannetteMenu" , boissonService.getByTaille(qe.getTaille()));
                        }
                        if (qe.getTaille().getProduitAttributes().getNom().contains("bouteille 250ml")){
                            model.addAttribute("bouteilleMenu" , boissonService.getByTaille(qe.getTaille()));
                        }
                        if (qe.getTaille().getProduitAttributes().getNom().contains("bouteille 1L")){
                            model.addAttribute("bouteille1LMenu" , boissonService.getByTaille(qe.getTaille()));
                        }
                    }
                }
            }

            //System.out.println(tailleInMenu);
            //List<Boisson> allBoissonInMenu  = boissonService.getAllByTaille(tailleInMenu);
            model.addAttribute("burgerList" , burgerList);
            model.addAttribute("produit" , menu);
            model.addAttribute("produitList" , menuService.listTopTen());
        }

        return "catalogue/details";
    }

    @GetMapping("/produit/{type}/panier/{action}/{id}")
    public String addToCart(@PathVariable(value="id") Long id,
                            @PathVariable(value="action") String action,
                            HttpServletRequest request ){
        //récupérer le burger choisi
        Optional<Burger> b = burgerService.getById(id);
        Burger burger = b.get();
        //stocké dans la session les produits choisis
        request.getSession().setAttribute("produits",checkProduit(quantityEntities , burger ,1, action));

        if (action.contains("addition") || action.contains("remove")){
            return "redirect:/showpanier";
        }else{
            return "redirect:/catalogue";
        }
    }



    @GetMapping("/showpanier")
    public String showpanier( HttpServletRequest request , Model model){
        model.addAttribute("produits" , request.getSession().getAttribute("produits"));
        return "catalogue/panier";
    }

    public List<QuantityEntity> checkProduit(List<QuantityEntity> qE , Burger b , int quantite , String action){
        boolean result = true;
        for(QuantityEntity q : qE){
            if(q.getBurger().getId() == b.getId()){
                if (action.contains("remove")){
                    if (q.getQuantite() == 1 ) {
                        qE.remove(q);
                    }else {
                        q.setQuantite(q.getQuantite() - quantite);
                    }
                }else  if (action.contains("addition")){
                    q.setQuantite(q.getQuantite() + quantite);
                }
                result = false;
            }
        }
        if(result){
            QuantityEntity qEn = new QuantityEntity();
            qEn.setBurger(b);
            qEn.setQuantite(quantite);
            qE.add(qEn);
        }

        return qE;
    }
}

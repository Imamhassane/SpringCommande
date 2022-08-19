package com.commandespringboot.controllers;

import com.commandespringboot.models.*;
import com.commandespringboot.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;


@Controller
@RequestMapping("/produit")
public class ProduitController {

    @Autowired
    private BurgerService burgerService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private TailleService tailleService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private MarqueService marqueService;
    @Autowired
    private BoissonService boissonService;
    @Autowired
    private QuantiteService quantiteService;
    @Autowired
    private ComplementService complementService;

    @GetMapping("/showForm")
    public String showForm(Model model){
        model.addAttribute("taillesBoisson" , tailleService.getTaillesbyType("BOISSON"));
        model.addAttribute("taillesFrittes" , tailleService.getTaillesbyType("FRITTES"));
        model.addAttribute("marques" , marqueService.listAll());
        model.addAttribute("burgers" , burgerService.listAll());
        return "produit/add";
    }

    ///////////////////////////////
    private void addBoissonToMenu(Integer nombreTailleBoissons, Long tailleBoissons, Menu menu) {
        if (tailleBoissons != null){
            Optional<Taille> t = tailleService.findbyid(tailleBoissons);
            Taille taille = t.get();
            QuantityEntity qeMenuBoisson1 = new QuantityEntity();
            qeMenuBoisson1.setMenu(menu);
            qeMenuBoisson1.setQuantite(nombreTailleBoissons);
            qeMenuBoisson1.setTaille(taille);
            quantiteService.saveQuantite(qeMenuBoisson1);
        }
    }
    private int getPrixBoisson(Integer nombreTailleBoissons, Long tailleBoissons) {
        int prix = 0;
        if (tailleBoissons != null){
            Optional<Taille> t = tailleService.findbyid(tailleBoissons);
            Taille taille = t.get();
            prix+= taille.getProduitAttributes().getPrix() * nombreTailleBoissons ;

        }
        return prix;
    }
    ///////////////////////////////

    @RequestMapping(value = "/save/{request}" , method= RequestMethod.POST)
    public String addProduit(@PathVariable String request , @RequestParam("image") MultipartFile file , @RequestParam(value = "nom" , required = false) String nom ,@RequestParam(value = "description" , required = false)String description
                            , @RequestParam(value = "prix" , required = false)Integer prix,@RequestParam(value = "type" , required = false)String typeComplement,@RequestParam(value = "tailleFritteCheck", required = false)Long idtailleFritteCheck,
                            @RequestParam(value = "tailleBoissonCheck" ,required = false)Long idtailleBoissonCheck,@RequestParam(value = "marque" , required = false)Long idmarque,@RequestParam(value = "quantite", required = false)Integer quantite,
                            @RequestParam(value = "burgers[]" ,required = false) ArrayList<Long> burgers,@RequestParam(value = "nombreBoisson0" ,required = false) Integer nombreTailleBoissons1,@RequestParam(value = "nombreBoisson1" ,required = false) Integer nombreTailleBoissons2,@RequestParam(value = "nombreBoisson2" ,required = false) Integer nombreTailleBoissons3,
                            @RequestParam(value = "tailleboissonChecks0" ,required = false) Long tailleBoissons1,@RequestParam(value = "tailleboissonChecks1" ,required = false) Long tailleBoissons2,@RequestParam(value = "tailleboissonChecks2" ,required = false) Long tailleBoissons3,
                             @RequestParam(value = "taillefrittesChecks[]" ,required = false) ArrayList<Long> taillefrittes
                            ) throws IOException {

        Image image = new Image();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        image.setNom(fileName);
        Image imgSaved = imageService.saveImage(image);


        switch (request){
            case "burger":
                Burger newburger = new Burger();
                ProduitAttributes pA = new ProduitAttributes();
                pA.setNom(nom);
                pA.setPrix(prix);
                newburger.setProduitAttributes(pA);
                newburger.setDescription(description);
                newburger.setImage(imgSaved);
                burgerService.saveBurger(newburger);
                break;
            case "menu":

                Menu menu = new Menu();
                ProduitAttributes pAMenu = new ProduitAttributes();
                HashMap<Taille , Integer> BoissonAndQuantity = new HashMap<>();
                List<Taille> tailleFrittesList =  new ArrayList<>();

                //add menu proprieties
                    //prix
                        int prixBurger = 0;
                        for (Long id : burgers){
                            Optional<Burger> b = burgerService.getById(id);
                            Burger burger = b.get();
                            prixBurger+=burger.getProduitAttributes().getPrix();
                        }
                        int prixFrittes = 0;
                            for (Long id : taillefrittes){
                                Optional<Taille> ta = tailleService.findbyid(id);
                                Taille tailleF = ta.get();
                                prixFrittes += tailleF.getProduitAttributes().getPrix();
                            }
                        int prixBoisson = 0;
                        prixBoisson+=getPrixBoisson(nombreTailleBoissons1, tailleBoissons1);
                        prixBoisson+=getPrixBoisson(nombreTailleBoissons2, tailleBoissons2);
                        prixBoisson+=getPrixBoisson(nombreTailleBoissons3, tailleBoissons3);
                        int prixMenu = prixFrittes + prixBoisson + prixBurger;
                    //
                    menu.setImage(imgSaved);
                    menu.setDescription(description);
                    pAMenu.setNom(nom);
                    pAMenu.setPrix(prixMenu);
                    menu.setProduitAttributes(pAMenu);
                    Menu menuSaved = menuService.saveMenu(menu);
                //end

                //add Burger to menu
                    for (Long id : burgers){
                        QuantityEntity qEBurger = new QuantityEntity();
                        Optional<Burger> b = burgerService.getById(id);
                        Burger burger = b.get();
                        qEBurger.setMenu(menuSaved);
                        qEBurger.setBurger(burger);
                        quantiteService.saveQuantite(qEBurger);
                    }
                //end add burger to menu

                //add boisson to menu

                addBoissonToMenu(nombreTailleBoissons1, tailleBoissons1, menuSaved);
                addBoissonToMenu(nombreTailleBoissons2, tailleBoissons2, menuSaved);
                addBoissonToMenu(nombreTailleBoissons3, tailleBoissons3, menuSaved);
                //end add boisson to menu

                // add frittes in menu
                for (Long id : taillefrittes){
                    Optional<Taille> ta = tailleService.findbyid(id);
                    Taille tailleF = ta.get();
                    tailleFrittesList.add(tailleF);
                }
                for (Taille t : tailleFrittesList){
                    QuantityEntity qEMenuFrittes = new QuantityEntity();
                    qEMenuFrittes.setTaille(t);
                    qEMenuFrittes.setMenu(menuSaved);

                    // ...
                    quantiteService.saveQuantite(qEMenuFrittes);
                }

                //end add frittes in menu

                break;
            case "complement" :
                switch (typeComplement){
                    case "boisson":
                        Boisson boisson = new Boisson();

                        Optional<Taille> tailleOptionalBoisson = tailleService.findbyid(idtailleBoissonCheck);
                        Taille tailleBoisson = tailleOptionalBoisson.get();

                        Optional<Marque> marqueOptional = marqueService.getById(idmarque);
                        Marque marque = marqueOptional.get();

                        boisson.setNom("Boisson");
                        boisson.setTaille(tailleBoisson);
                        boisson.setMarque(marque);
                        boisson.setStock(quantite);
                        boisson.setImage(imgSaved);

                        //save
                        boissonService.saveBoisson(boisson);
                        break;
                    case "fritte":
                        Complement complement = new Complement();

                        Optional<Taille> tailleOptionalFritte = tailleService.findbyid(idtailleFritteCheck);
                        Taille tailleFritte = tailleOptionalFritte.get();

                        complement.setNom("Fritte");
                        complement.setTaille(tailleFritte);
                        complement.setImage(imgSaved);

                        //save
                        complementService.saveComplement(complement);
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }

        String uploadDir = "src/main/resources/static/upload/" + imgSaved.getId();
        ImageService.saveFile(uploadDir, fileName, file);

        return "redirect:/produit/list";
    }



    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("burgers" , burgerService.listAll());
        model.addAttribute("menus" , menuService.listAll());
        model.addAttribute("complements" , complementService.listAll());

        return  "produit/list";
    }

    @RequestMapping(value = "/updateTaille" , method = RequestMethod.POST)
    public String updateTaille( @RequestParam("checks[]")ArrayList<Long> ids ,
                                @RequestParam("prix[]") ArrayList<Integer> prix ){
        List<Taille> all = tailleService.listAll();


        return "redirect:/produit/add";
    }
}

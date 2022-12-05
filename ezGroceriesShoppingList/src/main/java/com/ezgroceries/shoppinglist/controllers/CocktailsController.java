package com.ezgroceries.shoppinglist.controllers;

import com.ezgroceries.shoppinglist.model.CocktailDBResponse;
import com.ezgroceries.shoppinglist.model.Cocktails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.ezgroceries.shoppinglist.service.CocktailService;

import java.util.List;
import java.util.Set;

@RestController
public class CocktailsController {
    private static final Logger log = LoggerFactory.getLogger(CocktailsController.class);
    private CocktailService cocktailService;
    private CocktailDBClient cocktailDBClient;

    public CocktailsController(CocktailService cocktailService){
        this.cocktailService = cocktailService;
            }

    @GetMapping("/cocktails")
    public Set<Cocktails> getCocktails(@RequestParam("search") String search) {

        log.info("about to return search result");
        return cocktailService.getCocktailsOpenFeign(search);
     }

    @GetMapping("/getCocktails")
    public List<Cocktails> getCocktails(){
       return cocktailService.getAllCocktails();
    }


}

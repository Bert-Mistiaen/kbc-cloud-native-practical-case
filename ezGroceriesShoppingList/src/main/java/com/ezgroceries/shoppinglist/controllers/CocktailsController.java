package com.ezgroceries.shoppinglist.controllers;

import com.ezgroceries.shoppinglist.model.Cocktail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ezgroceries.shoppinglist.service.CocktailsService;

import java.util.Set;

@RestController
public class CocktailsController {
    private static final Logger log = LoggerFactory.getLogger(CocktailsController.class);
    private CocktailsService cocktailsService;

    @Autowired
    public CocktailsController(CocktailsService cocktailsService){
        this.cocktailsService = cocktailsService;
    }

    @GetMapping("/cocktails")
    public Set<Cocktail> getCocktails(@RequestParam("search") String search) {
        cocktailsService.setCocktailsList();
        log.info("about to return search result");
        return cocktailsService.getCocktailsList(search);
     }


}

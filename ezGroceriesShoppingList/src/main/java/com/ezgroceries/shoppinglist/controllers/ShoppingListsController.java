package com.ezgroceries.shoppinglist.controllers;

import com.ezgroceries.shoppinglist.model.Cocktails;
import com.ezgroceries.shoppinglist.model.ShoppingList;
import com.ezgroceries.shoppinglist.service.CocktailService;
import com.ezgroceries.shoppinglist.service.ShoppingListService;
import org.hibernate.cache.spi.SecondLevelCacheLogger_$logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.*;
import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ShoppingListsController {

    private static final Logger log = LoggerFactory.getLogger(ShoppingListsController.class);
    private ShoppingListService shoppingListService;
    private CocktailService cocktailService;
    private ShoppingList sl;
    private Cocktails c;

    public ShoppingListsController(ShoppingListService shoppingListService, CocktailService cocktailService){
        this.shoppingListService = shoppingListService;
        this.cocktailService = cocktailService;
    }

    @PostMapping("/shopping-lists")
    public ResponseEntity<Void> createShoppingList(@RequestBody String name)
    {
        log.info("--- Creating new shopping list ---");
        ShoppingList newShoppingList =  shoppingListService.create(name);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{shoppingListId}")
                .buildAndExpand(newShoppingList.getShoppingListId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/shopping-lists/{strShoppingListId}/cocktail")
    public ResponseEntity<Void> addCocktail(@PathVariable String strShoppingListId, @RequestBody String strCocktailId) {
        log.info("adding cocktail to shopping list");
        UUID cocktailId = UUID.fromString(strCocktailId);
        UUID shoppingListId = UUID.fromString(strShoppingListId);

        Optional<ShoppingList> shoppingList = shoppingListService.getShoppingList(shoppingListId);
        shoppingList.ifPresent(theS -> {
            sl = theS;
        });

        Optional<Cocktails> cocktail = cocktailService.getCocktail(cocktailId);
        cocktail.ifPresent(theC -> {
            c = theC;
        });

        sl.getCocktails().add(c);
        shoppingListService.save(sl);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{shoppingListId}")
                .buildAndExpand(c.getCocktailId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}

package com.ezgroceries.shoppinglist.controllers;

import com.ezgroceries.shoppinglist.model.Cocktail;
import com.ezgroceries.shoppinglist.model.ShoppingList;
import com.ezgroceries.shoppinglist.service.CocktailService;
import com.ezgroceries.shoppinglist.service.ShoppingListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Set;

@RestController
public class ShoppingListsController {

    private static final Logger log = LoggerFactory.getLogger(ShoppingListsController.class);
    private CocktailService cocktailService;
    private ShoppingListService shoppingListService;

    public ShoppingListsController(CocktailService cocktailService, ShoppingListService shoppingListService){
        this.cocktailService = cocktailService;
        this.shoppingListService = shoppingListService;
    }

    @PostMapping("/shopping-lists")
    public ResponseEntity<Void> createShoppingList(@RequestBody String name)
    {

        ShoppingList newShoppingList =  shoppingListService.create(name);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{shoppingListId}")
                .buildAndExpand(newShoppingList.getShoppingListId())
                .toUri();
        return ResponseEntity.created(location).build();
    }



}

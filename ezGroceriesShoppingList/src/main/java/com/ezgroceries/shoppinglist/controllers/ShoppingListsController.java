package com.ezgroceries.shoppinglist.controllers;

import com.ezgroceries.shoppinglist.model.Cocktails;
import com.ezgroceries.shoppinglist.model.ShoppingList;
import com.ezgroceries.shoppinglist.model.ShoppingListOut;
import com.ezgroceries.shoppinglist.service.CocktailService;
import com.ezgroceries.shoppinglist.service.ShoppingListService;
import org.hibernate.cache.spi.SecondLevelCacheLogger_$logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@RestController
public class ShoppingListsController {

    private static final Logger log = LoggerFactory.getLogger(ShoppingListsController.class);
    private ShoppingListService shoppingListService;
    private CocktailService cocktailService;
    private ShoppingList sl;
    private ShoppingList sl1;
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

        Optional<ShoppingList> shoppingList = shoppingListService.getShoppingList(strShoppingListId);
        shoppingList.ifPresentOrElse(theS -> {
            sl = theS;
            log.info("--- found shoppinglist ---");
        },
                ()-> {
                    log.info("no shoppinglist found");
                });


        Optional<Cocktails> cocktail = cocktailService.getCocktail(strCocktailId);
        cocktail.ifPresentOrElse(theC -> {
            sl.getCocktails().add(theC);
            shoppingListService.save(sl);
            log.info("saved cocktail to shoppinglist");
            c = theC;

        },
                () -> {
                    log.info("no cocktail found in table");
                });

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{shoppingListId}")
                .buildAndExpand(c.getCocktailId())
                .toUri();

        return ResponseEntity.created(location).build();



    }

    @GetMapping("/shopping-lists/{strShoppingListId}")
    public ShoppingListOut getOneShoppingList(@PathVariable String strShoppingListId){


        Optional<ShoppingList> shoppingList = shoppingListService.getShoppingList(strShoppingListId);
        shoppingList.ifPresent(theS -> {
            sl1 = theS;
        });

        Set<String> ingredients = new HashSet<>() {
        };
        for (Cocktails cocktail :sl1.getCocktails()){
            String[] ingrIn = cocktail.getIngredients();

            for (String oneIngr : ingrIn){
               ingredients.add(oneIngr);
            }
        }
        ShoppingListOut slOut = new ShoppingListOut(sl1.getShoppingListId(), sl1.getName(), ingredients);

        return slOut;
    }

    @GetMapping("/shopping-lists")
    public List<ShoppingListOut> getShoppingLists(){


        List<ShoppingList> shoppingLists = shoppingListService.getShoppingList();
        List<ShoppingListOut> listSlOut = new ArrayList<>();
        

        for (ShoppingList oneSl :shoppingLists) {
            Set<String> ingredients = new HashSet<>() {
            };
            for (Cocktails cocktail : oneSl.getCocktails()) {
                String[] ingrIn = cocktail.getIngredients();

                for (String oneIngr : ingrIn) {
                    ingredients.add(oneIngr);
                }
            }
            ShoppingListOut slOut = new ShoppingListOut(oneSl.getShoppingListId(), oneSl.getName(), ingredients);
            listSlOut.add(slOut);
        }
        

        return listSlOut;
    }
    
    
}

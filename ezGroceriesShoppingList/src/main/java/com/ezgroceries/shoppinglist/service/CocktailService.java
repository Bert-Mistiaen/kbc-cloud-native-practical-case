package com.ezgroceries.shoppinglist.service;

import com.ezgroceries.shoppinglist.controllers.CocktailDBClient;
import com.ezgroceries.shoppinglist.controllers.CocktailsController;
import com.ezgroceries.shoppinglist.model.CocktailDBResponse;
import com.ezgroceries.shoppinglist.model.Cocktails;
import com.ezgroceries.shoppinglist.repository.CocktailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CocktailService {

    private static final Logger log = LoggerFactory.getLogger(CocktailsController.class);
    private CocktailDBClient cocktailDBClient;
    private CocktailRepository cocktailRepository;
    public CocktailService(CocktailRepository cocktailRepository, CocktailDBClient cocktailDBClient){
        this.cocktailRepository = cocktailRepository;
        this.cocktailDBClient = cocktailDBClient;
    }

    public CocktailService() {

    }

    public void saveCocktail(Cocktails c){
        cocktailRepository.save(c);
    }

    public Set<Cocktails> getCocktailsListByNameStartsWith(String search) {
        return cocktailRepository.findByNameStartsWith(search);
    }

    /*public void setCocktailsList()
    {
        Cocktails c = new Cocktails();
        //c.setCocktailId(UUID.randomUUID());
        c.setName("Margerita");
        c.setGlass("Cocktail glass");
        c.setInstructions("Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten..");
        c.setImage("https://www.thecocktaildb.com/images/media/drink/wpxpvu1439905379.jpg");
        String[] ingrC = new String[]{"Tequila", "Triple sec", "Lime juice", "Salt"};
        c.setIngredients(ingrC);
        cocktailRepository.save(c);

        Cocktails d = new Cocktails();
        //d.setCocktailId(UUID.fromString("d615ec78-fe93-467b-8d26-5d26d8eab073"));
        d.setName("Blue Margerita");
        d.setGlass("Cocktail glass");
        d.setInstructions("Rub rim of cocktail glass with lime juice. Dip rim in coarse salt..");
        d.setImage("https://www.thecocktaildb.com/images/media/drink/qtvvyq1439905913.jpg");
        String[] ingrD = new String[]{"Tequila", "Blue Curacao", "Lime juice", "Salt"};
        d.setIngredients(ingrD);
        cocktailRepository.save(d);
    } */

    public Optional<Cocktails> getCocktail(String cocktailId) {
        return cocktailRepository.findById(cocktailId);
    }

    public List<Cocktails> getAllCocktails() {
        return (List<Cocktails>) cocktailRepository.findAll();

    }

    public Set<Cocktails> getCocktailsOpenFeign(String search){

        CocktailDBResponse cocktailDBResponse = cocktailDBClient.searchCocktails(search);
        Set<Cocktails> respCocktails = new HashSet<>();
        for (CocktailDBResponse.DrinkResource foundDrink: cocktailDBResponse.getDrinks()) {

            String[] ingredients = new String[3];
            ingredients[0] = foundDrink.getStrIngredient1();
            ingredients[1] = foundDrink.getStrIngredient2();
            ingredients[2] = foundDrink.getStrIngredient3();

            //public Cocktails(String name, String glass, String instructions, String image, String[] ingredients)
            Cocktails cocktail = new Cocktails(foundDrink.getStrDrink(), foundDrink.getStrGlass(), foundDrink.getStrInstructions(), foundDrink.getStrDrinkThumb(), ingredients);
            respCocktails.add(cocktail);
        }
        return respCocktails;
    }
}

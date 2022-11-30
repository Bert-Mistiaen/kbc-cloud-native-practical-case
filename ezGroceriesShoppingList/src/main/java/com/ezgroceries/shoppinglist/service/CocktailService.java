package com.ezgroceries.shoppinglist.service;

import com.ezgroceries.shoppinglist.controllers.CocktailsController;
import com.ezgroceries.shoppinglist.model.Cocktails;
import com.ezgroceries.shoppinglist.repository.CocktailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CocktailService {

    private static final Logger log = LoggerFactory.getLogger(CocktailsController.class);
    private CocktailRepository cocktailRepository;

    public CocktailService(CocktailRepository cocktailRepository){
        this.cocktailRepository = cocktailRepository;

    }

    public void saveCocktail(Cocktails c){
        cocktailRepository.save(c);
    }

    public Set<Cocktails> getCocktailsList(String search) {
        return cocktailRepository.findAll();
    }

    public void setCocktailsList()
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



    }

    public Optional<Cocktails> getCocktail(String cocktailId) {
        return cocktailRepository.findById(cocktailId);
    }
}

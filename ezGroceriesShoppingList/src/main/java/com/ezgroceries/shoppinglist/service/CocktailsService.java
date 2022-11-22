package com.ezgroceries.shoppinglist.service;

import com.ezgroceries.shoppinglist.controllers.CocktailsController;
import com.ezgroceries.shoppinglist.model.Cocktail;
import com.ezgroceries.shoppinglist.repository.CocktailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CocktailsService {

    private static final Logger log = LoggerFactory.getLogger(CocktailsController.class);
    private CocktailsRepository cocktailsRepository;

    public CocktailsService(CocktailsRepository cocktailsRepository){
        this.cocktailsRepository = cocktailsRepository;

    }

    public void saveCocktail(Cocktail c){
        cocktailsRepository.save(c);
    }

    public Set<Cocktail> getCocktailsList(String search) {
        return cocktailsRepository.findAll();
    }

    public void setCocktailsList()
    {
        Cocktail c = new Cocktail();
        c.setCocktailId(UUID.fromString("23b3d85a-3928-41c0-a533-6538a71e17c4"));
        c.setName("Margerita");
        c.setGlass("Cocktail glass");
        c.setInstructions("Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten..");
        c.setImage("https://www.thecocktaildb.com/images/media/drink/wpxpvu1439905379.jpg");
        c.setIngredients(new String[]{"Tequila", "Triple sec", "Lime juice", "Salt"});
        cocktailsRepository.save(c);

        Cocktail d = new Cocktail();
        d.setCocktailId(UUID.fromString("d615ec78-fe93-467b-8d26-5d26d8eab073"));
        d.setName("Blue Margerita");
        d.setGlass("Cocktail glass");
        d.setInstructions("Rub rim of cocktail glass with lime juice. Dip rim in coarse salt..");
        d.setImage("https://www.thecocktaildb.com/images/media/drink/qtvvyq1439905913.jpg");
        d.setIngredients(new String[]{"Tequila", "Blue Curacao", "Lime juice", "Salt"});
        cocktailsRepository.save(d);



    }
}

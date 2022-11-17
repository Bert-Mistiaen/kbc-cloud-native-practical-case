package service;

import model.Cocktails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CocktailsService {

    public List<Cocktails> getCocktailsList (String searched)
    {
        List<Cocktails> cocktails = null;

        Cocktails c = new Cocktails();
        c.setCocktailId(UUID.fromString("23b3d85a-3928-41c0-a533-6538a71e17c4"));
        c.setName("Margerita");
        c.setGlass("Cocktail glass");
        c.setInstructions("Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten..");
        c.setImage("https://www.thecocktaildb.com/images/media/drink/wpxpvu1439905379.jpg");
        c.setIngredients(new String[]{"Tequila", "Triple sec", "Lime juice", "Salt"});

        cocktails.add(c);

        Cocktails d = new Cocktails();
        d.setCocktailId(UUID.fromString("d615ec78-fe93-467b-8d26-5d26d8eab073"));
        d.setName("Blue Margerita");
        d.setGlass("Cocktail glass");
        d.setInstructions("Rub rim of cocktail glass with lime juice. Dip rim in coarse salt..");
        d.setImage("https://www.thecocktaildb.com/images/media/drink/qtvvyq1439905913.jpg");
        d.setIngredients(new String[]{"Tequila", "Blue Curacao", "Lime juice", "Salt"});

        cocktails.add(d);

        cocktails.stream().filter(cocktails1 -> cocktails1.getName().startsWith(searched)).findAny();

        return cocktails;
    }
}

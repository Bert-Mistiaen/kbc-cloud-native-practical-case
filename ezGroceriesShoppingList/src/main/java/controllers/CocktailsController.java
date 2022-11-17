package controllers;

import model.Cocktails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import service.CocktailsService;

import java.util.List;

@RestController
public class CocktailsController {
    private static final Logger log = LoggerFactory.getLogger(CocktailsController.class);
    private CocktailsService cocktailsService;

    public CocktailsController(CocktailsService cocktailsService){
        this.cocktailsService = cocktailsService;
    }

    @GetMapping("/cocktails")
    public List<Cocktails> getCocktails(@RequestParam String search) {
        return cocktailsService.getCocktailsList(search);
     }


}

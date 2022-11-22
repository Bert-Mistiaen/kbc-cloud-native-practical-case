package com.ezgroceries.shoppinglist;

import com.ezgroceries.shoppinglist.model.Cocktail;
import com.ezgroceries.shoppinglist.service.CocktailsService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class EzGroceriesShoppingListApplication {

    public static void main(String[] args) {
        SpringApplication.run(EzGroceriesShoppingListApplication.class, args);
    }

}

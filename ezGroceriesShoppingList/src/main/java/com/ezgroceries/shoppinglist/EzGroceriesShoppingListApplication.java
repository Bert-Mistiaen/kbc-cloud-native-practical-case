package com.ezgroceries.shoppinglist;

import com.ezgroceries.shoppinglist.service.CocktailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EzGroceriesShoppingListApplication {

    private static final Logger log = LoggerFactory.getLogger(EzGroceriesShoppingListApplication.class);

    public static void main(String[] args) {

        log.info("starting up");
        SpringApplication.run(EzGroceriesShoppingListApplication.class, args);

    }

}

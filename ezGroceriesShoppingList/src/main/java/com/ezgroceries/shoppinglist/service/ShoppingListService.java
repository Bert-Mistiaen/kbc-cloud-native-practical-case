package com.ezgroceries.shoppinglist.service;

import com.ezgroceries.shoppinglist.model.ShoppingList;
import com.ezgroceries.shoppinglist.repository.ShoppingListRepository;
import org.springframework.stereotype.Service;

@Service
public class ShoppingListService {
    private final ShoppingListRepository shoppingListRepository;

    public ShoppingListService(ShoppingListRepository shoppingListRepository) {
            this.shoppingListRepository = shoppingListRepository;
    }

    public ShoppingList create(String name) {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setName(name);

        return shoppingListRepository.save(shoppingList);
    }


}

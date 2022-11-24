package com.ezgroceries.shoppinglist.repository;

import com.ezgroceries.shoppinglist.model.ShoppingList;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListRepository {


    ShoppingList save(ShoppingList shoppingList);
}

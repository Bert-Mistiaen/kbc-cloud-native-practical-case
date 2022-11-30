package com.ezgroceries.shoppinglist.repository;

import com.ezgroceries.shoppinglist.model.ShoppingList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShoppingListRepository extends CrudRepository<ShoppingList, String> {
    ShoppingList save(ShoppingList shoppingList);
}

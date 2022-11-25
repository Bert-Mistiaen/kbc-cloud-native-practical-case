package com.ezgroceries.shoppinglist.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

public class ShoppingListOut
{
    @Getter
    @Setter
    private UUID shoppingListId;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Set<String> ingredients;

    public ShoppingListOut(UUID shoppingListId, String name, Set<String> ingredients) {
        this.shoppingListId = shoppingListId;
        this.name = name;
        this.ingredients = ingredients;
    }
}

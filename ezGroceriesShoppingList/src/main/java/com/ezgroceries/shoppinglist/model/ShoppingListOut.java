package com.ezgroceries.shoppinglist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Set;

public class ShoppingListOut
{
    @Getter
    @Setter
    private String shoppingListId;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Set<String> ingredients;

    public ShoppingListOut(String shoppingListId, String name, Set<String> ingredients) {
        this.shoppingListId = shoppingListId;
        this.name = name;
        this.ingredients = ingredients;
    }
}

package com.ezgroceries.shoppinglist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class ShoppingList {
    @Id
    @GeneratedValue(generator = "custom-uuid")
    @Column(name = "shopping_list_id", nullable = false)
    @Getter
    @Setter
    private UUID shoppingListId;

    @Getter
    @Setter
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cocktailsId")
    @Getter
    @Setter
    private Cocktail cocktails;


    public ShoppingList(){

    };


}

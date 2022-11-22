package com.ezgroceries.shoppinglist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "cocktailId", referencedColumnName = "cocktailId")
    @Getter
    @Setter
    private Set<Cocktail> cocktails;


    public ShoppingList(){

    };


}

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

    public Set<Cocktails> getCocktails() {
        return cocktails;
    }

    public void setCocktails(Set<Cocktails> cocktails) {
        this.cocktails = cocktails;
    }

    @ManyToMany
    @JoinTable(name = "shopppingLists_cocktails", joinColumns = { @JoinColumn(name = "shoppingListId")},
    inverseJoinColumns = {@JoinColumn(name = "cocktailId")})
    @Getter
    @Setter
    private Set<Cocktails> cocktails;


    public ShoppingList(){

    };

    public ShoppingList(String name) {

        this.name = name;
    }


}

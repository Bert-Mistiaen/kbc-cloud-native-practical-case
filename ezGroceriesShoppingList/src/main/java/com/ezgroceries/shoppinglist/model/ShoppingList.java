package com.ezgroceries.shoppinglist.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
public class ShoppingList {
    @Id
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "shopping_list_id", length = 36, nullable = false, updatable = false)
    @Getter
    @Setter
    private String shoppingListId;

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

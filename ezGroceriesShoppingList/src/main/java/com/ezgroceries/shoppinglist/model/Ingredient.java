package com.ezgroceries.shoppinglist.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="Ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(generator = "custom-uuid")
    private UUID ingredientId;

    private String ingredientName;

    @ManyToOne
    @JoinColumn(name = "cocktails_cocktail_id")
    private Cocktail cocktail;

    public Cocktail getCocktails() {
        return cocktail;
    }

    public void setCocktails(Cocktail cocktail) {
        this.cocktail = cocktail;
    }

    public Ingredient() {}

}

package model;

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
    private cocktails cocktails;

    public model.cocktails getCocktails() {
        return cocktails;
    }

    public void setCocktails(model.cocktails cocktails) {
        this.cocktails = cocktails;
    }

    public Ingredient() {}

}

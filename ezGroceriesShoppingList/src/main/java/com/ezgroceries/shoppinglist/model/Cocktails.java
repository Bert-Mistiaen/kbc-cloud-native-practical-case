package com.ezgroceries.shoppinglist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
public class Cocktails {

       @Id
       @GeneratedValue(generator = "custom-uuid")
       @Setter
       @Getter
       private UUID cocktailId;

       @Getter
       @Setter
       private String name;

       @Getter
       @Setter
       private String glass;
       @Getter
       @Setter
       private String instructions;
       @Getter
       @Setter
       private String image;

       @Getter
       @Setter
       private String[] ingredients;

       public Cocktails(){

       }

       @ManyToMany(mappedBy = "cocktails")
       @Getter
       @Setter
       private Set<ShoppingList> shoppingLists;

       public Cocktails(UUID cocktailId, String name, String glass, String instructions, String image, String[] ingredients)
       {
              this.cocktailId = cocktailId;
              this.name = name;
              this.glass = glass;
              this.instructions = instructions;
              this.image = image;
              this.ingredients = ingredients;

       }
}

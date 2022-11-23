package com.ezgroceries.shoppinglist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
public class Cocktail {

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

       public Cocktail(){

       }


       @OneToMany(mappedBy = "cocktails")
       @Getter
       @Setter
       private Set<ShoppingList> shoppingList;

}

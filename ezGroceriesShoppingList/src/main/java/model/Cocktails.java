package model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Cocktails {

       @Id
       @Column(name= "cocktailId")
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



}

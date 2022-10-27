package model;


import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
public class cocktails {


       /** "cocktailId": "23b3d85a-3928-41c0-a533-6538a71e17c4",
                "name": "Margerita",
                "glass": "Cocktail glass",
                "instructions": "Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten..",
                "image": "https://www.thecocktaildb.com/images/media/drink/wpxpvu1439905379.jpg",
                "ingredients": [
                "Tequila",
                "Triple sec",
                "Lime juice",
                "Salt"
                ]
        */
       @Id
       @Column(name= "cocktailId")
       @GeneratedValue(generator = "custom-uuid")
       private UUID cocktailId;

       private String name;
       private String instructions;
       private String image;

       @OneToMany(mappedBy="cocktail")
       private List<Ingredient> ingredients;





}

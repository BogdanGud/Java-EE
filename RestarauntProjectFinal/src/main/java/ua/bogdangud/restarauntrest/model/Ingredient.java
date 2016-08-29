package ua.bogdangud.restarauntrest.model;


import javax.persistence.*;

@Entity
@Table(name = "ingridient")
public class Ingredient {

    @Id
    @SequenceGenerator(name = "ingredient_id_seq",
            sequenceName = "ingredient_id_seq",
            allocationSize = 1)

    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "ingredient_id_seq")
    @Column(name = "id", updatable = false)
    private int id;

    @Column(name = "name")
    private String ingredientName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}

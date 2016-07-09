package ua.bogdangud.restaraunt.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "warehouse")
public class Warehouse implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "ingridient_id")
    private Ingredient ingredient;

    @Column(name = "number")
    private int number;

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "ingredient=" + ingredient +
                ", number=" + number +
                '}';
    }
}

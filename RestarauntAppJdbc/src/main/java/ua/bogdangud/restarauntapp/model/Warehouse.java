package ua.bogdangud.restarauntapp.model;

/**
 * Created by bogdan on 09-Jun-16.
 */
public class Warehouse {
    private int id;
    private int ingredientId;
    private int number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
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
                "id=" + id +
                ", ingredientId=" + ingredientId +
                ", number=" + number +
                '}';
    }
}

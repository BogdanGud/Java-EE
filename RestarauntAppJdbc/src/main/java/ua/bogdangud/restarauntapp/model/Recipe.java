package ua.bogdangud.restarauntapp.model;

/**
 * Created by bogdan on 09-Jun-16.
 */
public class Recipe {
    private int id;
    private int dishId;
    private int ingredientId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }
}

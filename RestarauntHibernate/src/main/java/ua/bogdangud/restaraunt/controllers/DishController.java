package ua.bogdangud.restaraunt.controllers;


import org.springframework.transaction.annotation.Transactional;
import ua.bogdangud.restaraunt.dao.HCategoryDishDao;
import ua.bogdangud.restaraunt.model.CategoryDish;
import ua.bogdangud.restaraunt.model.Dish;

public class DishController extends AbstractController<Dish> {
    private HCategoryDishDao categoryDish;
    @Transactional
    public void createDish() {
        Dish dish = new Dish();
        dish.setDishName("test");
        dish.setCategoryDish((CategoryDish) categoryDish.getById(5));
        dish.setPrice(555);
        dish.setWeight(555);
        System.out.println(dish);
        create(dish);


    }

    public void setCategoryDish(HCategoryDishDao categoryDish) {
        this.categoryDish = categoryDish;
    }
}

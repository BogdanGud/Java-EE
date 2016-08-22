package ua.bogdangud.restarauntrest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.bogdangud.restarauntrest.model.CategoryDish;
import ua.bogdangud.restarauntrest.model.Dish;
import ua.bogdangud.restarauntrest.service.DishService;

import java.util.List;

@RestController
public class RESTDishController {
    private DishService dishService;
    public DishViewModel dishViewModel;



    @RequestMapping(value = "/api/dishes", method = RequestMethod.GET)
    public List<Dish> getDishes() {
       return dishService.getAllDishes();
    }

    @RequestMapping(value = "/dish/byname/{dishName}", method = RequestMethod.GET)
    public DishViewModel getDishByName(@PathVariable String dishName) {
        Dish dish = dishService.getByName(dishName);
        return new DishViewModel(dish.getDishName());
    }

    @RequestMapping(value = "/api/dish/{dishId}", method = RequestMethod.DELETE)
    public void deleteDish (@PathVariable Integer dishId) {
        dishService.deleteDish(dishId);

    }

    @RequestMapping(value = "/api/dish/", method = RequestMethod.POST)
    @ResponseBody
    public void saveDish (@RequestBody CreateEditDishViewModel dish) {
        //employeeService.saveEmployee(employeeId);
        System.out.println(dish.toString());
        Dish newDish = new Dish();
        newDish.setDishName(dish.getDishName());
        newDish.setPrice(dish.getPrice());
        newDish.setWeight(dish.getWeight());
        CategoryDish categoryDish = new CategoryDish();
        categoryDish.setId(dish.getCategoryId());
        newDish.setCategoryDish(categoryDish);
        dishService.saveDish(newDish);

    }

    @Autowired
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }
}

package ua.bogdangud.restarauntrest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.bogdangud.restarauntrest.model.Dish;
import ua.bogdangud.restarauntrest.service.DishService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DishController {
    private DishService dishService;
    public DishViewModel dishViewModel;



    @RequestMapping(value = "/dishes", method = RequestMethod.GET)
    public List<DishViewModel> getDishes() {
       //ModelMapper modelMapper = new ModelMapper();
        List<Dish> dishes = dishService.getAllDishes();
        List<DishViewModel> dishViewModels = dishes.stream().map(dish -> new DishViewModel(dish.getDishName())).collect(Collectors.toList());

        return dishViewModels;
    }

    @RequestMapping(value = "/dish/byname/{dishName}", method = RequestMethod.GET)
    public DishViewModel getDishByName(@PathVariable String dishName) {
        Dish dish = dishService.getByName(dishName);
        return new DishViewModel(dish.getDishName());
    }


    @Autowired
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }
}

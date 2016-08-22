package ua.bogdangud.restarauntrest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.bogdangud.restarauntrest.service.DishService;

import java.util.Map;

@Controller
public class DishController {
    private DishService dishService;

    @RequestMapping(value = "/dish-list", method = RequestMethod.GET)
    public String getDishList(Map<String, Object> model ) {
        model.put("dishes", dishService.getAllDishes());
        return "dish-list";
    }

    @Autowired
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }
}

package ua.bogdangud.restarauntrest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.bogdangud.restarauntrest.service.DishService;

import java.util.Map;

@Controller
public class DishController {
    private DishService dishService;

    @RequestMapping(value = "/admin-dish-list", method = RequestMethod.GET)
    public String getDishList(Map<String, Object> model ) {
        model.put("dishes", dishService.getAllDishes());
        return "adminDish-list";
    }

    @RequestMapping(value = "/client-dishes", method = RequestMethod.GET)
    public String getEmployees (Map<String, Object> model ) {
        model.put("dishes", dishService.getAllDishes());
        return "client-dishes";

    }

    @RequestMapping(value = "/dish", method = RequestMethod.GET)
    public ModelAndView employee (@RequestParam("dishName") String dishName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("dish", dishService.getByName(dishName));
        modelAndView.setViewName("dish");
        return modelAndView;
    }

    @Autowired
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }
}

package ua.bogdangud.restarauntrest.service;


import org.springframework.transaction.annotation.Transactional;
import ua.bogdangud.restarauntrest.dao.HDishDao;
import ua.bogdangud.restarauntrest.model.Dish;

import java.util.List;

public class DishService {
    private HDishDao dishDao;

    @Transactional
    public List<Dish> getAllDishes (){
        return dishDao.getAll();
    }

    @Transactional
    public Dish  getByName(String dishName) {
        return dishDao.getByName(dishName);
    }

    @Transactional
    public  void deleteDish (Integer dishId){
        dishDao.deleteEntityById(dishId);
    }

    @Transactional
    public void saveDish (Dish dish) {
        dishDao.add(dish);
    }

    public void setDishDao(HDishDao dishDao) {
        this.dishDao = dishDao;
    }


}

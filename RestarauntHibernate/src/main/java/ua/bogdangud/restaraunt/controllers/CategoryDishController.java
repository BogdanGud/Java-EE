package ua.bogdangud.restaraunt.controllers;


import org.springframework.transaction.annotation.Transactional;
import ua.bogdangud.restaraunt.dao.AbstractDao;
import ua.bogdangud.restaraunt.model.CategoryDish;

import java.util.List;

public class CategoryDishController extends AbstractController<CategoryDish>{
    private AbstractDao categoryDao;

    @Override
    @Transactional
    public List<CategoryDish> getAll() {
        return categoryDao.getAll();
    }

    public void setCategoryDao(AbstractDao categoryDao) {
        this.categoryDao = categoryDao;
    }
}

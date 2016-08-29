package ua.bogdangud.restarauntrest.service;


import org.springframework.transaction.annotation.Transactional;
import ua.bogdangud.restarauntrest.dao.HCategoryDishDao;
import ua.bogdangud.restarauntrest.model.CategoryDish;

public class CategoryDishService {
    private HCategoryDishDao categoryDishDao;


    @Transactional
    public CategoryDish getCategoryDish(Integer id) {
        return categoryDishDao.getById(id);
    }

    public void setCategoryDishDao(HCategoryDishDao categoryDishDao) {
        this.categoryDishDao = categoryDishDao;
    }
}

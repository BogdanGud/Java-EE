package ua.bogdangud.restarauntrest.dao;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.bogdangud.restarauntrest.model.CategoryDish;

import java.util.List;

public class HCategoryDishDao extends AbstractDao<CategoryDish>{

    @Override
    @Transactional
    public CategoryDish getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select c from CategoryDish c where c.id = :id");
        query.setParameter("id", id);
        return (CategoryDish) query.uniqueResult();
    }

    @Override
    public List<CategoryDish> getAll() {
        return sessionFactory.getCurrentSession().createQuery("select c from CategoryDish c").list();
    }
}

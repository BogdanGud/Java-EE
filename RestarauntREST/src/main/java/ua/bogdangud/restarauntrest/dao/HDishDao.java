package ua.bogdangud.restarauntrest.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.bogdangud.restarauntrest.model.Dish;

import java.util.List;


public class HDishDao extends AbstractDao<Dish> {
    @Override
    @Transactional
    public Dish getById(Integer id) {
        //return sessionFactory.getCurrentSession().load(Dish.class, id);
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select d from Dish d where d.id = :dishId");
        query.setParameter("dishId", id);
        return (Dish) query.uniqueResult();
    }

    @Override
    @Transactional
    public List<Dish> getAll() {
        return sessionFactory.getCurrentSession().createQuery("select e from Dish e").list();
    }

    @Transactional
    public Dish getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Dish e where e.dishName like :name");
        query.setParameter("name", name);
        return (Dish) query.uniqueResult();
    }


    @Transactional
    public  void deleteEntityById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Dish d where d.id = :dishId");
        query.setParameter("dishId", id);
        query.executeUpdate();
    }
}

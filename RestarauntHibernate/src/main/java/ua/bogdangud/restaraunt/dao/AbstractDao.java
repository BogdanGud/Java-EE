package ua.bogdangud.restaraunt.dao;


import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class AbstractDao<E> {
    protected SessionFactory sessionFactory;

    @Transactional
    public void add(E entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    public abstract E getById(Integer id);

    public List<E> getByName(String name) {
        return null;
    }

    public abstract List<E> getAll();

    public void deleteEntityById(int id) {}

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}

package ua.bogdangud.restaraunt.dao;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.bogdangud.restaraunt.model.Position;

import java.util.List;

public class HPositionDao extends AbstractDao<Position> {
    @Override
    @Transactional
    public Position getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Position e where e.id = :id");
        query.setParameter("id",id);
        return (Position) query.uniqueResult();
    }

    @Override
    @Transactional
    public List<Position> getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Position e where e.name like :name");
        query.setParameter("name", name);
        return query.list();
    }

    @Override
    @Transactional
    public List<Position> getAll() {
        return sessionFactory.getCurrentSession().createQuery("select e from Position e").list();
    }
}

package ua.bogdangud.restaraunt.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.bogdangud.restaraunt.model.Employee;

import java.util.List;


public class HEmployeeDao extends AbstractDao<Employee> {
    @Override
    @Transactional
    public Employee getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Employee e where e.id = :id");
        query.setParameter("id",id);
        return (Employee) query.uniqueResult();
    }

    @Override
    @Transactional
    public List<Employee> getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Employee e where e.name like :name");
        query.setParameter("name", name);
        return query.list();
    }

    @Override
    @Transactional
    public List<Employee> getAll() {
        return sessionFactory.getCurrentSession().createQuery("select e from Employee e").list();
    }

    @Override
    @Transactional
    public void deleteEntityById(int id) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "delete from Employee e where e.id = :employeeId";
        Query query = session.createQuery(hql);
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}

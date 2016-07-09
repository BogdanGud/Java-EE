package ua.bogdangud.restaraunt.controllers;


import org.springframework.transaction.annotation.Transactional;
import ua.bogdangud.restaraunt.dao.AbstractDao;

import java.util.List;

public abstract class AbstractController<E> {


    protected AbstractDao dao;

    public void setDao(AbstractDao dao) {
        this.dao = dao;
    }

    public void create(E item) {
        dao.add(item);
    }

    @Transactional
    public List<E> getAll() {
        return dao.getAll();
    }

    @Transactional
    public E getById(Integer id) {
        return (E) dao.getById(id);
    }

    @Transactional
    public List<E> getByName(String name) {
        return (List<E>) dao.getByName(name);
    }

    public void deleteEntityById(int id) {
        dao.deleteEntityById(id);

    }

}

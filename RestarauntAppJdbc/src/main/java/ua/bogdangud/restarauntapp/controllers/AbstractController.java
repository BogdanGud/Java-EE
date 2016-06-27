package ua.bogdangud.restarauntapp.controllers;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.bogdangud.restarauntapp.DAO.AbstractDao;

import java.util.List;


public class AbstractController <T, K> {
    private PlatformTransactionManager txManager;
    private AbstractDao dao;

    @Transactional(propagation = Propagation.REQUIRED)
    public List <T> getAll() {
        return dao.getAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void add(T t) {
        dao.add(t);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delById(K id) {
        dao.delById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<T> getByName(String name) {
        return dao.getByName(name);
    }

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setDao(AbstractDao dao) {
        this.dao = dao;
    }
}

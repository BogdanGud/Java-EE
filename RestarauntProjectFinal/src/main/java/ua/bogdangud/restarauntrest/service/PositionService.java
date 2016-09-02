package ua.bogdangud.restarauntrest.service;

import org.springframework.transaction.annotation.Transactional;
import ua.bogdangud.restarauntrest.dao.HPositionDao;
import ua.bogdangud.restarauntrest.model.Position;

/**
 * Created by bogdan on 01-Sep-16.
 */
public class PositionService {
    private HPositionDao positionDao;

    @Transactional
    public Position getPosition(Integer id) {
        return positionDao.getById(id);
    }



    public void setPositionDao(HPositionDao positionDao) {
        this.positionDao = positionDao;
    }
}

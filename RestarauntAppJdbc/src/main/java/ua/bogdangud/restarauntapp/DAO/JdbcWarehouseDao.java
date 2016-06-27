package ua.bogdangud.restarauntapp.DAO;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.bogdangud.restarauntapp.model.Warehouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class JdbcWarehouseDao extends AbstractDao<Warehouse, Integer> {
    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void add(Warehouse Warehouse) {
        /*
            INSERT INTO Warehouse (ingredient_id, qty)
        */
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO warehouse VALUES (?, ?)")) {
            statement.setInt(1, Warehouse.getIngredientId());
            statement.setInt(2, Warehouse.getNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void delById(Integer id) {
        delBySqlId("DELETE FROM warehouse WHERE ingridient_id = ?", id);//Table and field "igredient" contain mistake - "ingridient" !!!!!!!!!
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void update(Integer id, Warehouse entity) {

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Warehouse getById(Integer id) {
        return getBySqlId("SELECT * FROM warehouse WHERE ingridient_id = ?", id); //Table and field "igredient" contain mistake - "ingridient" !!!!!!!!!
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Warehouse> getByName(String name) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Warehouse> getAll() {
        return getAllSql("SELECT * FROM Warehouse");
    }

    @Override
    Warehouse createEntity(ResultSet resultSet) throws SQLException {
        Warehouse Warehouse = new Warehouse();
        Warehouse.setIngredientId(resultSet.getInt("ingridient_id")); //Table and field "igredient" contain mistake - "ingridient" !!!!!!!!!
        Warehouse.setNumber(resultSet.getInt("number"));
        return Warehouse;
    }
}

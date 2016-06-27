package ua.bogdangud.restarauntapp.DAO;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.bogdangud.restarauntapp.model.Dish;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by bogdan on 23-Jun-16.
 */
public class JdbcDishDao extends AbstractDao<Dish, Integer> {
    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void add(Dish dish) {
        // INSERT INTO dish (dish_name, category_id, price, weight) VALUES ('Steak', (SELECT id FROM category_dish WHERE category_name = 'Meat'), 100, 0.400);
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO dish (name, category_id, price, weight) VALUES (?, ?, ?, ?)")) {
            statement.setString(1, dish.getName());
            statement.setInt(2, dish.getCategoryId());
            statement.setDouble(3, dish.getPrice());
            statement.setDouble(4, dish.getWeight());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void delById(Integer id) {
        delBySqlId("DELETE FROM dish WHERE id = ?", id);
    }

    @Override
    public void update(Integer id, Dish entity) {

    }

    @Override
    public Dish getById(Integer id) {
        return getBySqlId("SELECT * FROM dish WHERE id = ?", id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Dish> getByName(String name) {
        return getBySqlName("SELECT * FROM dish WHERE name LIKE ?", name);
    }

    @Override
    public List<Dish> getAll() {
        return getAllSql("SELECT * FROM dish");
    }

    @Override
    Dish createEntity(ResultSet resultSet) throws SQLException {
        Dish dish = new Dish();
        dish.setId(resultSet.getInt("id"));
        dish.setName(resultSet.getString("name"));
        dish.setCategoryId(resultSet.getInt("category_id"));
        dish.setPrice(resultSet.getDouble("price"));
        dish.setWeight(resultSet.getDouble("weight"));
        return dish;
    }
}

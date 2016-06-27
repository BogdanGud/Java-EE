package ua.bogdangud.restarauntapp.DAO;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.bogdangud.restarauntapp.model.Recipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by bogdan on 23-Jun-16.
 */
public class JdbcRecepiDao  extends AbstractM2MDao<Recipe, Integer, Integer>{
    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void add(Recipe recipe) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO recepy (dish_id, ingredient_id) VALUES (?, ?, ?)")) {
            statement.setInt(1, recipe.getDishId());
            statement.setInt(2, recipe.getIngredientId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delByEntity(Recipe recipe) {

    }


    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Recipe> getById(Integer id) {
        return get("SELECT * FROM recepy WHERE dish_id = ? ", id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Recipe> getByValue(Integer value) {
        return get("SELECT * FROM recepy WHERE ingredient_id = ? ", value);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List <Recipe> getAll() {
        return get("SELECT * FROM recepy", null);
    }

    @Override
    Recipe createEntity(ResultSet resultSet) throws SQLException {
        Recipe recipe = new Recipe();
        recipe.setId(resultSet.getInt("id"));
        recipe.setDishId(resultSet.getInt("dish_id"));
        recipe.setIngredientId(resultSet.getInt("ingridient_id"));
        return null;
    }
}

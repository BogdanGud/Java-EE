package ua.bogdangud.restarauntapp.DAO;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.bogdangud.restarauntapp.model.Ingredient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Table "igredient" consist mistake - "ingrIdient" !!!!!!!!!
 */
public class JdbcIngredientDao extends AbstractDao <Ingredient, Integer> {
    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void add(Ingredient ingredient) {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO ingridient (name) VALUES(?)")) {
            statement.setString(1, ingredient.getIngredientName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void delById(Integer id) {
        //Table and field "igredient" contain mistake - "ingridient" !!!!!!!!!
        delBySqlId("DELETE FROM ingridient WHERE id = ?", id);

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void update(Integer id, Ingredient entity) {

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Ingredient getById(Integer id) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Ingredient> getByName(String name) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Ingredient> getAll() {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    Ingredient createEntity(ResultSet resultSet) throws SQLException {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(resultSet.getInt("id"));
        ingredient.setIngredientName(resultSet.getString("name"));
        return ingredient;
    }
}

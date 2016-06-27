package ua.bogdangud.restarauntapp.DAO;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.bogdangud.restarauntapp.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by bogdan on 19-Jun-16.
 */
public class JdbcCategoryDishDao extends AbstractDao<Category, Integer>{

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void add(Category category) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement
                     ("INSERT INTO category (categoryName) VALUES (?)")) {
            statement.setString(1, category.getCategoryName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    @Transactional
    public void delById(Integer id) {
        delBySqlId("DELETE FROM dish WHERE id =?", id);

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void update(Integer id, Category entity) {

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Category getById(Integer id) {
        return getBySqlId("SELECT * FROM category WHERE id = ?", id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Category> getByName(String name) {
        return getBySqlName("SELECT * FROM category WHERE LIKE ?", name);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Category> getAll() {
        return getAllSql("SELECT * FROM category");
    }

    @Override
    Category createEntity(ResultSet resultSet) throws SQLException {
        Category category = new Category();
        category.setId(resultSet.getInt("id"));
        category.setCategoryName(resultSet.getString("name"));
        return category;
    }
}

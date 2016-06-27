package ua.bogdangud.restarauntapp.DAO;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bogdan on 15-Jun-16.
 */
public abstract class AbstractDao<T, K> {
    DataSource dataSource;

    public abstract void add(T entity);

    public abstract void delById(K id);

    public abstract void update(K id, T entity);

    public abstract T getById(K id);

    public abstract List<T> getByName(String name);

    public abstract List<T> getAll();


    @Transactional(propagation = Propagation.MANDATORY)
    List<T> getAllSql(String sql) {
        List<T> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(createEntity(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void delBySqlId(String sql, Integer id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public T getBySqlId(String sql, Integer id) {
        T result = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = createEntity(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public List getBySqlName(String sql, String name) {
        List<T> result = new ArrayList();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                T entity = createEntity(resultSet);
                result.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    abstract T createEntity(ResultSet resultSet) throws SQLException;
}

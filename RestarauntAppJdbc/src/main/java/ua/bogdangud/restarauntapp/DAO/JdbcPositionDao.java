package ua.bogdangud.restarauntapp.DAO;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.bogdangud.restarauntapp.model.Position;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by bogdan on 20-Jun-16.
 */
public class JdbcPositionDao extends AbstractDao<Position, Integer> {
    @Override
    public void add(Position entity) {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Position (name) VALUES (?)")) {

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void delById(Integer id) {
        delBySqlId("DELETE FROM position WHERE id = ?", id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void update(Integer id, Position entity) {

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Position getById(Integer id) {
        return getBySqlId("SELECT * FROM position WHERE id = ?", id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Position> getByName(String name) {
        return getBySqlName("SELECT * FROM position WHERE Position_name LIKE ?", name);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Position> getAll() {
        return getAllSql("SELECT * FROM position");
    }

    @Override
    Position createEntity(ResultSet resultSet) throws SQLException {
        Position position = new Position();
        position.setId(resultSet.getInt("id"));
        position.setPositionName(resultSet.getString("name"));
        return position;
    }
}

package ua.bogdangud.restarauntapp.DAO;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.bogdangud.restarauntapp.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class JdbcEmloyeeDao extends AbstractDao<Employee, Integer> {

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void add(Employee employee) {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Employee (name, surname, birth_date, " +
                    "phone_number, position_id, salary) VALUES (?,?,?,?,?,?)")) {
            statement.setString(1, employee.getName());
            statement.setString(2,employee.getSurname());
            statement.setTimestamp(3, employee.getBirthDate());
            statement.setString(4, employee.getPhoneNumber());
            statement.setInt(5, employee.getPositionId());
            statement.setDouble(6, employee.getSalary());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void delById(Integer id) {
        delBySqlId("DELETE FROM Employee WHERE id = ?", id);
    }

    @Override
    public void update(Integer id, Employee entity) {

    }

    @Override
    public Employee getById(Integer id) {
        return null;
    }

    @Override
    public List getByName(String name) {
        return getBySqlName("SELECT * FROM employee WHERE name LIKE ?", name);
    }

    @Override
    public List getAll() {
        return getAllSql("SELECT * FROM Employee");
    }

    @Override
    Employee createEntity(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("id"));
        employee.setName(resultSet.getString("name"));
        employee.setSurname(resultSet.getString("surname"));
        employee.setBirthDate(resultSet.getTimestamp("birth_date"));
        employee.setPhoneNumber(resultSet.getString("phone_number"));
        employee.setPositionId(resultSet.getInt("position_id"));
        employee.setSalary(resultSet.getDouble("salary"));
        return employee;
    }
}

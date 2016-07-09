package ua.bogdangud.restaraunt.controllers;


import org.springframework.transaction.annotation.Transactional;
import ua.bogdangud.restaraunt.dao.AbstractDao;
import ua.bogdangud.restaraunt.model.Employee;
import ua.bogdangud.restaraunt.model.Position;

import java.sql.Timestamp;
import java.util.GregorianCalendar;

public class EmployeeController extends AbstractController<Employee> {
    private AbstractDao positionDao;

    @Transactional
    public void createEmployee() {
        Employee employee = new Employee();
        employee.setName("Bogdan");
        employee.setSurname("Gud");
        employee.setBirthDate(new Timestamp(new GregorianCalendar(2000,01,01).getTimeInMillis()));
        employee.setPhoneNumber("123-45-67");
        employee.setPosition((Position) positionDao.getById(1));
        employee.setSalary(5000);
        System.out.println(employee);
        create(employee);
    }

    public void setPositionDao(AbstractDao positionDao) {
        this.positionDao = positionDao;
    }
}

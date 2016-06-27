package ua.bogdangud.restarauntapp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.bogdangud.restarauntapp.controllers.AbstractController;
import ua.bogdangud.restarauntapp.model.Dish;
import ua.bogdangud.restarauntapp.model.Employee;

import java.sql.Timestamp;
import java.util.GregorianCalendar;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    static ApplicationContext context;

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("application-context.xml");
        testEmployee();
        testDish();
        testWarehouse();

    }

    private static void testEmployee() {
        AbstractController employeeDao = (AbstractController) context.getBean("employeeController");
        employeeDao.getAll().forEach(System.out::println);
        System.out.println("---------------");
        Employee newEmployee = new Employee();
        newEmployee.setName("TestName");
        newEmployee.setSurname("TestSurname");
        newEmployee.setPositionId(1);
        newEmployee.setPhoneNumber("testNumber");
        newEmployee.setBirthDate(new Timestamp(new GregorianCalendar(1989, 15, 8).getTimeInMillis()));
        newEmployee.setSalary(1000);
        employeeDao.add(newEmployee);
        System.out.println("Test employee: " + employeeDao.getByName("TestName"));
        System.out.println("---------------");
        employeeDao.getByName("TestName").forEach(employee -> employeeDao.delById(((Employee) employee).getId()));
        employeeDao.getAll().forEach(System.out::println);
    }

    private static void testDish() {
        System.out.println("TEST DISH");
        AbstractController dishController = (AbstractController) context.getBean("dishController");

        dishController.getAll().forEach(System.out::println);
        System.out.println("---------------");
        Dish newDish = new Dish();
        newDish.setName("Test");
        newDish.setCategoryId(1);
        newDish.setPrice(1);
        newDish.setWeight(1);
        dishController.add(newDish);
        System.out.println("Test Dish: " + dishController.getByName("Test"));
        System.out.println("---------------");
        dishController.getByName("Test").forEach(dish -> dishController.delById(((Dish) dish).getId()));
        dishController.getAll().forEach(System.out::println);


    }

    private static void testWarehouse() {
        System.out.println("TEST WAREHOUSE");
        AbstractController warehouse = (AbstractController) context.getBean("warehouseController");
        warehouse.getAll().forEach(System.out::println);

    }


}

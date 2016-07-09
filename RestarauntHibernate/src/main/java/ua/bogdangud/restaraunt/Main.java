package ua.bogdangud.restaraunt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.bogdangud.restaraunt.controllers.CategoryDishController;
import ua.bogdangud.restaraunt.controllers.DishController;
import ua.bogdangud.restaraunt.controllers.EmployeeController;


public class Main {

    private EmployeeController employeeController;
    private DishController dishController;
    private CategoryDishController categoryDishController;


    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

    public void setCategoryDishController(CategoryDishController categoryDishController) {
        this.categoryDishController = categoryDishController;
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();
    }

    private void start() {

        employeeController.getAll().forEach(System.out::println);
        employeeController.createEmployee();
        employeeController.getAll().forEach(System.out::println);
        employeeController.deleteEntityById(5);
        employeeController.getAll().forEach(System.out::println);

        dishController.getAll().forEach(System.out::println);
        dishController.getByName("Borsch").forEach(System.out::println);
        System.out.println(dishController.getByName("Latte"));
        System.out.println(dishController.getById(47));
        //dishController.createDish();
        dishController.deleteEntityById(47);
        dishController.getAll().forEach(System.out::println);

        categoryDishController.getAll().forEach(System.out::println);


    }
}

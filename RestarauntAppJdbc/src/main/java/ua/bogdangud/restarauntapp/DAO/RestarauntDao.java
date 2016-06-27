package ua.bogdangud.restarauntapp.DAO;

import ua.bogdangud.restarauntapp.model.*;

import java.util.List;

/**
 * Created by bogdan on 22-Jun-16.
 */
public interface RestarauntDao {

    public void addEmployee (Employee employee);
    public void delEmployeeById (int id);
    public Employee getEmployeeByName (String name);
    public List<Employee> getAllEmployee();

    public void addDish (Dish dish);
    public void delDishById(int id);
    public Dish getDishByName(String dishName);
    public List<Dish> getAllDish();

    public void addOrder (Booking bookingNum);
    public void addDishInBooking (int dishId, int boookinId);
    public void delDishFromBooking (int dishId, int bookingId);
    public void delBooking (int bookingId);
    public void closeBooking (int bookingId);
    public void getBooking (int bookingId);
    public List <Booking> getAllBooking();

    public void addIngredient (Ingredient ingredient);
    public int getIngedientByName(String ingrediantName);

    public void addOnWarehouse (int ingredient);
    public void delFromWarehouse(int ingredientId);
    public double getAllIngridients();
    public Ingredient getIngredByName(String name);











}

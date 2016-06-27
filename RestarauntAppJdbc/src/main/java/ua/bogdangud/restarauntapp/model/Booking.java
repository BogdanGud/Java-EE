package ua.bogdangud.restarauntapp.model;

import java.util.Date;

/**
 * Created by bogdan on 09-Jun-16.
 */
public class Booking {
    private  int id;
    private  int orderNumber;
    private  int employeeId;
    private  int tableNumber;
    private Date date;
    private boolean IsOpen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isOpen() {
        return IsOpen;
    }

    public void setOpen(boolean open) {
        IsOpen = open;
    }
}

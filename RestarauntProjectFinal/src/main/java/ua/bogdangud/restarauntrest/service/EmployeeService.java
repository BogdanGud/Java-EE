package ua.bogdangud.restarauntrest.service;


import org.springframework.transaction.annotation.Transactional;
import ua.bogdangud.restarauntrest.dao.HEmployeeDao;
import ua.bogdangud.restarauntrest.model.Employee;

import java.util.List;

public class EmployeeService {

    private HEmployeeDao employeeDao;

    @Transactional
    public List<Employee> getEmployees() {
        return employeeDao.getAll();
    }

    @Transactional
    public Employee getEmployeeByName(String employeeName) {
        return employeeDao.getByName(employeeName);
    }

    @Transactional
    public Employee getEmployeeById(Integer employeeId) {
        return employeeDao.getById(employeeId);
    }


    @Transactional
    public void setEmployeeDao(HEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Transactional
    public void deleteEmployee(Integer employeeId) {
        employeeDao.deleteEntityById(employeeId);
    }

    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDao.add(employee);
    }

    @Transactional
    public void updateEmployee(Employee employee) {
        employeeDao.updateEntity(employee);
    }


}

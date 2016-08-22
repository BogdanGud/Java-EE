package ua.bogdangud.restarauntrest.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.bogdangud.restarauntrest.model.Employee;
import ua.bogdangud.restarauntrest.model.Position;
import ua.bogdangud.restarauntrest.service.EmployeeService;

import java.util.List;

@RestController
public class RESTEmployeeController {
    private EmployeeService employeeService;



    @RequestMapping(value = "/api/employees", method = RequestMethod.GET)
    public List<Employee> employee () {
        return employeeService.getEmployees();

    }

    @RequestMapping(value = "/api/employee/byname/{employeeName}", method = RequestMethod.GET)
    public Employee employee (@PathVariable String employeeName) {
        return employeeService.getEmployeeByName(employeeName);

    }

    @RequestMapping(value = "/api/employee/byid/{employeeId}", method = RequestMethod.GET)
    public Employee employee (@PathVariable Integer employeeId) {
        return employeeService.getEmployeeById(employeeId);

    }

    @RequestMapping(value = "/api/employee/{employeeId}", method = RequestMethod.DELETE)
    public void deleteEmployee (@PathVariable Integer employeeId) {
        employeeService.deleteEmployee(employeeId);

    }

    @RequestMapping(value = "/api/employee/", method = RequestMethod.POST)
    @ResponseBody
    public void saveEmployee (@RequestBody CreateEditEmployeeViewModel employee) {
        //employeeService.saveEmployee(employeeId);
        System.out.println(employee.toString());
        Employee newEmployee = new Employee();

        newEmployee.setName(employee.getName());
        newEmployee.setSurname(employee.getSurname());
        newEmployee.setPhoneNumber(employee.getPhoneNumber());
        Position position = new Position();
        position.setId(employee.getPositionId());
        newEmployee.setPosition(position);
        newEmployee.setSalary(employee.getSalary());
        newEmployee.setBirthDate(employee.getBirthDate());
        employeeService.saveEmployee(newEmployee);

    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}

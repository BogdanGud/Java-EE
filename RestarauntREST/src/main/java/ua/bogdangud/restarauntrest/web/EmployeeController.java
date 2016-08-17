package ua.bogdangud.restarauntrest.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.bogdangud.restarauntrest.model.Employee;
import ua.bogdangud.restarauntrest.service.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;

//    @RequestMapping(value = "/employees", method = RequestMethod.GET)
//    public String employees (Map<String, Object> model , @RequestParam(value = "take", required = false) Optional<Integer>  take) {
//
//        int newTake = !take.isPresent() || take.get() > employeeService.getEmployees().size() || take.get() < 0
//                ? employeeService.getEmployees().size()
//                : take.get();
//
//        model.put("employees", employeeService.getEmployees().subList(0, newTake));
//
//
//        return "employees";
//
//        //return "index";
//    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> employee () {
        return employeeService.getEmployees();

    }

    @RequestMapping(value = "/employee/byname/{employeeName}", method = RequestMethod.GET)
    public Employee employee (@PathVariable String employeeName) {
        return employeeService.getEmployeeByName(employeeName);

    }

    @RequestMapping(value = "/employee/byid/{employeeId}", method = RequestMethod.GET)
    public Employee employee (@PathVariable Integer employeeId) {
        return employeeService.getEmployeeById(employeeId);

    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}

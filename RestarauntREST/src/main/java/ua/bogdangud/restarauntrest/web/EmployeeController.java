package ua.bogdangud.restarauntrest.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.bogdangud.restarauntrest.service.EmployeeService;

import java.util.Map;

@Controller
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
    public String getEmployees (Map<String, Object> model ) {
        model.put("employees", employeeService.getEmployees());
        return "employees";

    }

    @RequestMapping(value = "/employees-list", method = RequestMethod.GET)
    public String getEmployeesList (Map<String, Object> model ) {
        model.put("employees", employeeService.getEmployees());
        return "employees-list";

    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ModelAndView employee (@RequestParam ("employeeName") String employeeName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employee", employeeService.getEmployeeByName(employeeName));
        modelAndView.setViewName("employee");
        return modelAndView;

    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}

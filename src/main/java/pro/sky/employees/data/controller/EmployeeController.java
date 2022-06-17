package pro.sky.employees.data.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employees.data.Employee;
import pro.sky.employees.data.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int department, @RequestParam double salary) {
        return service.add(firstName, lastName, department, salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int department, @RequestParam double salary) {
        return service.remove(firstName, lastName, department, salary);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int department, @RequestParam double salary) {
        return service.find(firstName, lastName, department, salary);
    }





    @GetMapping("/departments/max-salary")
     public Collection<Employee> findEmployeeWithMaxSalary(@RequestParam Integer departmentId) {
        return service.findEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("/departments/min-salary")
    public Collection<Employee> findEmployeeWithMinSalary(@RequestParam Integer departmentId) {
        return service.findEmployeeWithMinSalary(departmentId);
    }

    @GetMapping("/departments/all-department")
    public Collection<Employee> findEmployeeDepartment(@RequestParam Integer departmentId) {
        return service.findEmployeeDepartment(departmentId);
    }

    @GetMapping(" /departments/all")
    public Collection<Employee> findAllEmployeeByDepartment() {
        return service.findAllEmployeeByDepartment();
    }
}

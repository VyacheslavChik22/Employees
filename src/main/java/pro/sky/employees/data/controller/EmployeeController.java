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

    @GetMapping
    public Collection<Employee> findAll() {
        return service.findAll();
    }



    @GetMapping("/departments/max-salary?departmentId")
     public Collection<Employee> findEmployeeWithMaxSalary() {
        return service.findEmployeeWithMaxSalary();
    }

    @GetMapping("/departments/min-salary?departmentId")
    public Collection<Employee> findEmployeeWithMinSalary() {
        return service.findEmployeeWithMinSalary();
    }

    @GetMapping("/departments/all?departmentId")
    public Collection<Employee> findEmployeeDepartment() {
        return service.findEmployeeDepartment();
    }

    @GetMapping(" /departments/all")
    public Collection<Employee> findAllEmployeeByDepartment() {
        return service.findAllEmployeeByDepartment();
    }
}

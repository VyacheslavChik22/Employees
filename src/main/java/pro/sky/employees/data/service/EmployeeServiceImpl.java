package pro.sky.employees.data.service;

import org.springframework.stereotype.Service;
import pro.sky.employees.data.Employee;
import pro.sky.employees.data.exeption.EmployeeAlreadyAddedException;
import pro.sky.employees.data.exeption.EmployeeNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employeeList;

    public EmployeeServiceImpl() {
        this.employeeList = new ArrayList<>();
    }

    @Override
    public Employee add(String firstName, String lastName, int department, double salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName, int department, double salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName, int department, double salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employeeList.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();

    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employeeList);

    }


    @Override
    public Employee findEmployeeWithMaxSalary(Integer departmentId) {
        return employeeList.stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new RuntimeException("Not found department"));
    }

    @Override
    public Employee findEmployeeWithMinSalary(Integer departmentId) {
        return employeeList.stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new RuntimeException("Not found department"));

    }


    @Override
    public Collection<Employee> findEmployeesFromDepartment(Integer departmentId) {
        return employeeList.stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }


    @Override
    public Collection<Employee> findAllEmployeeByDepartments(Integer departmentId) {

        return null;


    }


}
package pro.sky.employees.data.service;

import org.springframework.stereotype.Service;
import pro.sky.employees.data.Employee;
import pro.sky.employees.data.exceptions.EmployeeAlreadyAddedException;
import pro.sky.employees.data.exceptions.EmployeeNotFoundException;
import pro.sky.employees.data.exceptions.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeService {
    private static final int LIMIT = 10;
    private final List<Employee> employees = new ArrayList<>();

    public Employee add(String name, String lastName) {
        Employee employee = new Employee(name, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee remove(String name, String lastName) {
        Employee employee = new Employee(name, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    public Employee find(String name, String lastName) {
        Employee employee = new Employee(name, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public List<Employee> allPersons() {
        return new ArrayList<>(employees);
    }
}

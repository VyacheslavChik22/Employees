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
    private final Map<String, Employee> employees = new HashMap<>();

    private String getKey(Employee employee) {
        return employee.getName() + "|" + employee.getLastName();
    }

    public Employee add(String name, String lastName) {
        Employee employee = new Employee(name, lastName);
        String key = getKey(employee);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            return employees.put(key, employee);

        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee remove(String name, String lastName) {

        String key = getKey(new Employee(name, lastName));
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
       return employees.remove(key);
    }

    public Employee find(String name, String lastName) {
        Employee employee = new Employee(name, lastName);
        if (!employees.containsKey(getKey(employee))) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public List<Employee> allPersons() {
        return new ArrayList<>(employees.values());
    }
}

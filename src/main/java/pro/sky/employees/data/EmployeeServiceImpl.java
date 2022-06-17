package pro.sky.employees.data;

import org.springframework.stereotype.Service;
import pro.sky.employees.data.exeption.EmployeeAlreadyAddedException;
import pro.sky.employees.data.exeption.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employeeList;

    public EmployeeServiceImpl() {
        this.employeeList = new ArrayList<>();
    }

    @Override
    public Employee add(String firstName, String lastName,int department,double salary) {
        Employee employee = new Employee(firstName, lastName,department,salary);
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName,int department,double salary) {
        Employee employee = new Employee(firstName, lastName,department,salary);
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName,int department,double salary) {
        Employee employee = new Employee(firstName, lastName,department,salary);
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
    public Collection<Employee> findEmployeeWithMaxSalary() {
        return null;
    }

    @Override
    public Collection<Employee> findEmployeeWithMinSalary() {
        return null;
    }

    @Override
    public Collection<Employee> findEmployeeDepartment() {
        return null;
    }

    @Override
    public Collection<Employee> findAllEmployeeByDepartment() {
        return null;
    }
}

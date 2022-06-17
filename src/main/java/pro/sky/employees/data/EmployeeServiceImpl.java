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
    public Collection<Employee> findEmployeeWithMaxSalary(Integer departmentId) {
        double max = 0;
        employeeList.stream().forEach(employee -> {
            if(max < employee.getSalary()){
                max =
            }

        });

        return null;
    }

    @Override
    public Collection<Employee> findEmployeeWithMinSalary(Integer departmentId) {
        return null;
    }

    @Override
    public Collection<Employee> findEmployeeDepartment(Integer departmentId) {
        return null;
    }

    @Override
    public Collection<Employee> findAllEmployeeByDepartment() {
        return Collections.unmodifiableList(employeeList);

    }
}

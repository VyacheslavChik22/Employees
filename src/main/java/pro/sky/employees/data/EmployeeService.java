package pro.sky.employees.data;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName,int department,double salary);

    Employee remove(String firstName, String lastName,int department,double salary);

    Employee find(String firstName, String lastName,int department,double salary);

    Collection<Employee> findAll();

    Collection<Employee> findEmployeeWithMaxSalary();

    Collection<Employee> findEmployeeWithMinSalary();

    Collection<Employee> findEmployeeDepartment();

    Collection<Employee> findAllEmployeeByDepartment();
}

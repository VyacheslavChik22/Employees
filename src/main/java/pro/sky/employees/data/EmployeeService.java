package pro.sky.employees.data;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName,int department,double salary);

    Employee remove(String firstName, String lastName,int department,double salary);

    Employee find(String firstName, String lastName,int department,double salary);


    Employee findEmployeeWithMaxSalary(Integer departmentId);

    Employee findEmployeeWithMinSalary(Integer departmentId);

    Employee findEmployeeDepartment(Integer departmentId);

    Collection<Employee> findAllEmployeeByDepartments();

    Collection<Employee> findAll();
}

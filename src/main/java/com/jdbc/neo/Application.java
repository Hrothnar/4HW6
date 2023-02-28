package com.jdbc.neo;

import com.jdbc.neo.dao.impl.EmployeeDAOimpl;
import com.jdbc.neo.model.Employee;

public class Application {
    public static void main(String[] args) {
        EmployeeDAOimpl employeeDAOimpl = new EmployeeDAOimpl();

        employeeDAOimpl.getAllEmployees().forEach(System.out::println);
        employeeDAOimpl.addEmployee(new Employee("Adam", "Thomson", "male", 46, 1L));
        employeeDAOimpl.getAllEmployees().forEach(System.out::println);

        System.out.println(employeeDAOimpl.getEmployee(1));

        System.out.println(employeeDAOimpl.getEmployee(3));
        employeeDAOimpl.updateEmployee(new Employee(26, 4), 3);
        System.out.println(employeeDAOimpl.getEmployee(3));

        System.out.println(employeeDAOimpl.getEmployee(6));
        employeeDAOimpl.removeEmployee(6);
        System.out.println(employeeDAOimpl.getEmployee(6));
    }
}

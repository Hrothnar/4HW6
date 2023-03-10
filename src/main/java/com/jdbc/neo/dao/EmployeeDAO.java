package com.jdbc.neo.dao;

import com.jdbc.neo.model.Employee;

import java.util.Set;

public interface EmployeeDAO {
    void addEmployee(Employee employee);
    Employee getEmployee(long id);
    Set<Employee> getAllEmployees();
    void updateEmployee(Employee employee, long id);
    void removeEmployee(long id);
}

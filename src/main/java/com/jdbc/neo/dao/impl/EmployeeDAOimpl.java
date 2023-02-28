package com.jdbc.neo.dao.impl;

import com.jdbc.neo.dao.EmployeeDAO;
import com.jdbc.neo.model.Employee;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class EmployeeDAOimpl implements EmployeeDAO {
    private final static String URL = "jdbc:postgresql://localhost:5432/skypro";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "nbv";
    private static final Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addEmployee(Employee employee) {
        final String SQL = "INSERT INTO employees(first_name, last_name, gender, age, city_id) VALUES (?, ?, ?, ?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1, employee.getFirst_name());
            statement.setString(2, employee.getLast_name());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setLong(5, employee.getCity_id());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee getEmployee(long id) {
        final String SQL = "SELECT * FROM employees WHERE id=?;";
        Employee employee = null;
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            long employee_id = resultSet.getLong("id");
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            String gender = resultSet.getString("gender");
            int age = resultSet.getInt("age");
            long city_id = resultSet.getLong("city_id");
            employee = new Employee(employee_id, first_name, last_name, gender, age, city_id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    @Override
    public Set<Employee> getAllEmployees() {
        Set<Employee> employeeSet = new HashSet<>();
        final String SQL = "SELECT * FROM employees;";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long employee_id = resultSet.getLong("id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                long city_id = resultSet.getLong("city_id");
                employeeSet.add(new Employee(employee_id, first_name, last_name, gender, age, city_id));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeSet;
    }

    @Override
    public void updateEmployee(Employee employee, long id) {
        final String SQL = "UPDATE employees SET age=?, city_id=? WHERE id=?;";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1, employee.getAge());
            statement.setLong(2, employee.getCity_id());
            statement.setLong(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeEmployee(long id) {
        final String SQL = "DELETE FROM employees WHERE id=?;";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

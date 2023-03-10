package com.jdbc.neo;

import com.jdbc.neo.dao.impl.CityDAOimpl;
import com.jdbc.neo.dao.impl.EmployeeDAOimpl;
import com.jdbc.neo.model.City;
import com.jdbc.neo.model.Employee;
import com.jdbc.neo.util.HibernateSessionFactoryUtil;
import org.hibernate.SessionFactory;

public class Application {
    public static void main(String[] args) {
        EmployeeDAOimpl employeeDAOimpl = new EmployeeDAOimpl();
        CityDAOimpl cityDAOimpl = new CityDAOimpl();

        employeeDAOimpl.getAllEmployees().forEach(System.out::println);
        cityDAOimpl.getAllCities().forEach(System.out::println);
        cityDAOimpl.removeCity(7);
        employeeDAOimpl.removeEmployee(9);
        cityDAOimpl.addCity(new City("Stockholm"));
        employeeDAOimpl.addEmployee(new Employee("Boris", "Tockar", "male", 44, cityDAOimpl.getCity(8)));

        employeeDAOimpl.getEmployee(2);
        cityDAOimpl.getCity(4);

        employeeDAOimpl.updateEmployee(new Employee(20, cityDAOimpl.getCity(4)), 3);
    }


}

package com.jdbc.neo.dao.impl;

import com.jdbc.neo.dao.EmployeeDAO;
import com.jdbc.neo.model.Employee;
import com.jdbc.neo.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeDAOimpl implements EmployeeDAO {

    @Override
    public void addEmployee(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    @Override
    public Employee getEmployee(long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class, id);
    }

    @Override
    public Set<Employee> getAllEmployees() {
        List<Employee> employeeList = (List<Employee>) HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .createQuery("FROM Employee")
                .list();
        return new HashSet<>(employeeList);
    }

    @Override
    public void updateEmployee(Employee employee, long id) {
        Employee employeeData = getEmployee(id);
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(new Employee(employeeData.getId(), employeeData.getFirst_name(), employeeData.getLast_name(), employeeData.getGender(), employee.getAge(), employee.getCity_id()));
            transaction.commit();
        }
    }

    @Override
    public void removeEmployee(long id) {
        Employee employee = getEmployee(id);
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }


}

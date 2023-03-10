package com.jdbc.neo.dao.impl;

import com.jdbc.neo.dao.CityDAO;
import com.jdbc.neo.model.City;
import com.jdbc.neo.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CityDAOimpl implements CityDAO {

    @Override
    public void addCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }
    }

    @Override
    public City getCity(long id) {
        City city = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            city = session.get(City.class, id);
        }
        return city;

    }

    @Override
    public Set<City> getAllCities() {
        List<City> cityList = (List<City>) HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .createQuery("FROM City")
                .list();
        return new HashSet<>(cityList);
    }

    @Override
    public void updateCity(City city, long id) {
        City cityData = getCity(id);
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(new City(cityData.getCity_id(), cityData.getCity_name()));
            transaction.commit();
        }
    }

    @Override
    public void removeCity(long id) {
        City city = getCity(id);
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        }
    }


}

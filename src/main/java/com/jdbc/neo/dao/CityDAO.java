package com.jdbc.neo.dao;

import com.jdbc.neo.model.City;

import java.util.Set;

public interface CityDAO {
    void addCity(City city);
    City getCity(long id);
    Set<City> getAllCities();
    void updateCity(City city, long id);
    void removeCity(long id);
}

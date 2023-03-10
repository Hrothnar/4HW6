package com.jdbc.neo.model;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long city_id;
    private String city_name;

    public City() {

    }

    public City(long city_id, String city_name) {
        this.city_id = city_id;
        this.city_name = city_name;
    }

    public City(String city_name) {
        this.city_name = city_name;
    }

    public long getCity_id() {
        return city_id;
    }

    public void setCity_id(long city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    @Override
    public String toString() {
        return "City{" +
                "city_id=" + city_id +
                ", city_name='" + city_name + '\'' +
                '}';
    }


}

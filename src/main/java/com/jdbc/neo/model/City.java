package com.jdbc.neo.model;

public class City {
    private long city_id;
    private String city_name;

    public City() {

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
}

package com.example.theweatherforecast;

public class CityObject {
    String cityName;
    double longitude;
    double latitude;


    public CityObject(String cityName,double longitude, double latitude) {
        this.cityName = cityName;
        this.longitude = longitude;
        this.latitude = latitude;
    }


    public String getCityName() {
        return cityName;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}

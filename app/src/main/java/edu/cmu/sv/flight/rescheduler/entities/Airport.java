package edu.cmu.sv.flight.rescheduler.entities;

/**
 * Created by hsuantzl on 2015/4/28.
 */
public class Airport {
    private String name;
    private String city;
    private String code;
    private double latitude;
    private double longitude;
    private String timezone;

    public Airport(String name, String city, String code,
                   double latitude, double longitude, String timezone) {
        this.name = name;
        this.city = city;
        this.code = code;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timezone = timezone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}

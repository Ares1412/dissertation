package com.wx.dissertation.model;

public class Sensor {

    private String id;  //传感器id
    private String type;    //传感器的类型
    private double longitude;   //经度信息
    private double latitude;    //纬度信息
    private String timestamp;   //时间戳

    public Sensor(String id, String type, double longitude, double latitude) {
        this.id = id;
        this.type = type;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Sensor() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }

}

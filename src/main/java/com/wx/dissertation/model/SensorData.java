package com.wx.dissertation.model;

public class SensorData {

    private String id;  //传感器id
    private double data;   //传感器采集到的数据数值
    private double error_upper;  //误差最大值
    private double error_lower;  //误差最小值
    private String time;    //数据采集的时间
    private String timestamp;   //时间戳

    public SensorData(String id, double data, String time) {
        this.id = id;
        this.data = data;
        this.time = time;
    }

    public SensorData() {
    }

    public SensorData(String id, double data, double error_upper, double error_lower, String time) {
        this.id = id;
        this.data = data;
        this.error_upper = error_upper;
        this.error_lower = error_lower;
        this.time = time;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setData(double data) {
        this.data = data;
    }

    public void setError_upper(double error_upper) {
        this.error_upper = error_upper;
    }

    public void setError_lower(double error_lower) {
        this.error_lower = error_lower;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public double getData() {
        return data;
    }

    public double getError_upper() {
        return error_upper;
    }

    public double getError_lower() {
        return error_lower;
    }

    public String getTime() {
        return time;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "id='" + id + '\'' +
                ", data=" + data +
                ", error_upper=" + error_upper +
                ", error_lower=" + error_lower +
                ", time='" + time + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}

package com.wx.dissertation.model;

public class TempSensorData {
    //上传的传感器数据对象
    private String id;  //传感器id
    private double data;   //传感器采集到的数据数值
    private String time;    //数据采集的时间

    public TempSensorData(String id, double data, String time) {
        this.id = id;
        this.data = data;
        this.time = time;
    }

    public TempSensorData() {
    }

    public String getId() {
        return id;
    }

    public double getData() {
        return data;
    }

    public String getTime() {
        return time;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setData(double data) {
        this.data = data;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "TempSensorData{" +
                "id='" + id + '\'' +
                ", data=" + data +
                ", time='" + time + '\'' +
                '}';
    }

}

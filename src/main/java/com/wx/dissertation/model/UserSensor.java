package com.wx.dissertation.model;

public class UserSensor {
    private String userId;      //用户ID
    private String sensorId;    //传感器ID
    private String timestamp;   //时间戳


    public UserSensor(String userId, String sensorId) {
        this.userId = userId;
        this.sensorId = sensorId;
    }

    public UserSensor() {
    }

    public String getUserId() {
        return userId;
    }

    public String getSensorId() {
        return sensorId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "UserSensor{" +
                "userId='" + userId + '\'' +
                ", sensorId='" + sensorId + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}

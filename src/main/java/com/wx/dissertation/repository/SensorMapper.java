package com.wx.dissertation.repository;

import com.wx.dissertation.model.Sensor;

import java.util.List;

public interface SensorMapper {
    //添加一个新的传感器
    void addSensor(Sensor sensor);
    //通过id查询传感器信息
    Sensor selectById(String id);
    //删除传感器
    void deleteById(String id);
    //查询所有传感器
    List<Sensor> selectAll();
}

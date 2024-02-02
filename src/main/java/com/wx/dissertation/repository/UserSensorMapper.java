package com.wx.dissertation.repository;

import com.wx.dissertation.model.UserSensor;

import java.util.List;

public interface UserSensorMapper {
    //添加一条用户-传感器关联信息
    void addUserSensor(UserSensor us);
    //通过用户ID查询传感器ID
    List<String> selectSensorListById(String id);
}

package com.wx.dissertation.service;

import com.wx.dissertation.model.Sensor;
import com.wx.dissertation.model.SensorData;

import java.util.List;

public interface SensorService {

    /*针对传感器信息的服务如下*/
    /**
     * 添加一个新的传感器
     * 需要传入传感器信息和对应的用户ID
     * 建立用户与传感器的关联关系
     * @param userId
     * @param sensor
     */
    void addSensor(String userId,Sensor sensor);

    /**
     * 通过用户ID查找出用户所对应的传感器列表
     * 对应传感器列表查询功能
     * @param userId
     * @return
     */
    List<Sensor> selectByUserId(String userId);

    /**
     * 通过传感器ID删除传感器信息，提供给管理员的服务
     * @param id
     */
    void deleteById(String id);

    /**
     * 查询所有传感器信息，提供给管理员的服务
     * @return
     */
    List<Sensor> selectAll();

    /*针对传感器采集数据的服务如下*/

    /**
     * 添加一条新的传感器采集的数据
     * @param sd
     */
    void addData(SensorData sd);

    /**
     * 通过传感器ID和用户选择的日期查询传感器采集的数据
     * 对应传感器采集数据的查询功能
     * @param id
     * @param date
     * @return
     */
    List<SensorData> selectDataByIdAndDate(String id,String date);

    /**
     * 通过传感器ID查询所有采集的数据
     * 提供给管理员的服务
     * @param id
     * @return
     */
    List<SensorData> selectDataById(String id);
}

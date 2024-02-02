package com.wx.dissertation.service.impl;

import com.wx.dissertation.controller.SensorController;
import com.wx.dissertation.model.Sensor;
import com.wx.dissertation.model.SensorData;
import com.wx.dissertation.model.UserSensor;
import com.wx.dissertation.repository.SensorDataMapper;
import com.wx.dissertation.repository.SensorMapper;
import com.wx.dissertation.repository.UserSensorMapper;
import com.wx.dissertation.service.SensorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Service("SensorService")
public class SensorServiceImpl implements SensorService {

    @Resource
    private UserSensorMapper usMapper;
    @Resource
    private SensorMapper sensorMapper;
    @Resource
    private SensorDataMapper sensorDataMapper;

    private static final Logger LOG = LoggerFactory.getLogger(SensorServiceImpl.class);

    /*针对传感器信息的服务如下*/
    @Override
    public void addSensor(String userId, Sensor sensor) {
        UserSensor us = new UserSensor(userId,sensor.getId());
        sensorMapper.addSensor(sensor);
        LOG.info(us.toString());
        usMapper.addUserSensor(us);
    }

    @Override
    public List<Sensor> selectByUserId(String userId) {
        List<Sensor> result = new LinkedList<>();
        List<String> sensorId_list = usMapper.selectSensorListById(userId);
        for(String sid: sensorId_list){
            Sensor temp = sensorMapper.selectById(sid);
            result.add(temp);
        }
        return result;
    }

    @Override
    public void deleteById(String id) {
        sensorMapper.deleteById(id);
    }

    @Override
    public List<Sensor> selectAll() {
        return sensorMapper.selectAll();
    }

    /*针对传感器采集数据的服务如下*/

    @Override
    public void addData(SensorData sd) {
        sensorDataMapper.addData(sd);
    }

    @Override
    public List<SensorData> selectDataByIdAndDate(String id, String date) {
        return sensorDataMapper.selectByIdAndDate(id,date);
    }

    @Override
    public List<SensorData> selectDataById(String id) {
        return sensorDataMapper.selectById(id);
    }
}

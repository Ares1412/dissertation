package com.wx.dissertation.repository;

import com.wx.dissertation.model.SensorData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SensorDataMapper {
    //添加一条新数据
    void addData(SensorData sd);
    //通过传感器ID和日期查询采集的数据
    List<SensorData> selectByIdAndDate(@Param("id") String id, @Param("date") String date);
    //通过传感器ID查询所有采集的数据
    List<SensorData> selectById(String id);
}

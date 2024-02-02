package com.wx.dissertation.controller;

import com.alibaba.fastjson.JSONObject;
import com.wx.dissertation.Util.PCA;
import com.wx.dissertation.model.Sensor;
import com.wx.dissertation.model.SensorData;
import com.wx.dissertation.model.TempSensorData;
import com.wx.dissertation.service.SensorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/sensor")
public class SensorController {

    private static final Logger LOG = LoggerFactory.getLogger(SensorController.class);

    @Resource
    private SensorService sensorService;

    /**
     * 获取用户传感器列表
     * @param id
     * @return
     */
    @RequestMapping(value="/getSensorList",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public List<Sensor> getSensorList(
            @RequestParam(value = "id")
                    String id){
        LOG.info("id = " + id);
        LOG.info("=======接口getSensorList已被成功调用=======");
        return sensorService.selectByUserId(id);
    }

    /**
     * 添加传感器
     * @param sensorInfo
     * @return
     */
    @RequestMapping(value="/addSensor",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public JSONObject addSensor(
            @RequestBody JSONObject sensorInfo
    ){
        JSONObject result = new JSONObject();
        LOG.info("sensorInfo = " + sensorInfo.toString());
        String user_id  = sensorInfo.getString("userid");
        String id = sensorInfo.getString("id");
        String type = sensorInfo.getString("type");
        double longitude = sensorInfo.getDouble("longitude");
        double latitude = sensorInfo.getDouble("latitude");
        Sensor sensor = new Sensor(id,type,longitude,latitude);
        LOG.info(sensor.toString());
        try {
            sensorService.addSensor(user_id,sensor);
            result.put("success",true);
            result.put("message","添加传感器成功");
        }catch (Exception e){
            result.put("success",false);
            result.put("message","添加传感器失败");
        }
        LOG.info("=======接口addSensor已被成功调用=======");
        return result;
    }

    /**
     * 获取传感器采集数据
     * @param id
     * @param date
     * @return
     */
    @RequestMapping(value="/getSensorData",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public List<SensorData> getSensorData(
            @RequestParam(value = "id")
                    String id,
            @RequestParam(value = "date")
                    String date
    ){
        LOG.info("id = " + id+" date = "+date);
        LOG.info("=======接口getSensorData已被成功调用=======");
        if(!date.equals("")){
            return sensorService.selectDataByIdAndDate(id,date);
        }else{
            return new ArrayList<>();
        }

    }

    /**
     * 上传传感器数据
     * @param tempSensorData
     * @return
     */
    @RequestMapping(value="/addSensorData",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public JSONObject addSensorData(
            @RequestBody TempSensorData tempSensorData
    ){
        JSONObject result = new JSONObject();
        LOG.info(tempSensorData.toString());
        String id = tempSensorData.getId();
        double data = tempSensorData.getData();
        String time;
        try {
            if(PCA.CheckAnswer(id,data)){
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                time = df.format(new Date());
                LOG.info(time);
                SensorData sensorData = new SensorData(
                        id,
                        PCA.getAnswer(id),
                        PCA.getError_upper(id),
                        PCA.getError_lower(id),
                        time);
                sensorService.addData(sensorData);
                result.put("success",true);
                result.put("message","上传数据成功，数据处理算法执行完毕");
            }else{
                result.put("success",true);
                result.put("message","上传数据成功");
            }
        }catch (Exception e){
            result.put("success",false);
            result.put("message","上传数据失败");
        }
        LOG.info("=======接口addSensorData已被成功调用=======");
        return result;
    }
}

package com.wx.dissertation.controller;

import com.alibaba.fastjson.JSONObject;
import com.wx.dissertation.Util.Random;
import com.wx.dissertation.model.User;
import com.wx.dissertation.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    UserService userService;

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    /**
     * 用户登录
     * @param name
     * @param password
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public JSONObject login(
            @RequestParam(value = "name")
            String name,
            @RequestParam(value = "password")
            String password
    ){
        LOG.info("name = "+name+" password = "+password);
        JSONObject result = new JSONObject();
        User user = userService.selectByName(name);
        if(user != null){
            if(user.getPassword().equals(password)){
                result.put("success",true);
                result.put("message","登录成功");
                result.put("userid",user.getId());
                return result;
            }
        }
        result.put("success",false);
        result.put("message","用户名或密码错误，登录失败");
        LOG.info("=======接口login已被成功调用=======");
        return result;
    }

    /**
     * 用户注册
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public JSONObject register(
            @RequestBody JSONObject userInfo
    ){
        JSONObject result = new JSONObject();
        String name = userInfo.getString("name");
        String password = userInfo.getString("password");
        String id = Random.getNumber();
        User newUser = new User(id,name,password);
        try {
            userService.addUser(newUser);
            result.put("success",true);
            result.put("message","用户注册成功");
        }catch (Exception e){
            result.put("success",false);
            result.put("message","用户注册失败");
        }
        LOG.info(newUser.toString());
        LOG.info("=======接口register已被成功调用=======");
        return result;
    }

    /**
     * 用户信息更新
     * @param user
     * @return
     */
    @RequestMapping(value="/updateUser",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public JSONObject updateUser(
            @RequestBody User user
    ) {
        LOG.info("user= "+user.toString());
        JSONObject result = new JSONObject();
        try {
            userService.update(user);
            result.put("success",true);
            result.put("message","用户信息更新成功");
        }catch (Exception e){
            e.printStackTrace();
            result.put("success",false);
            result.put("message","用户信息更新失败");

        }
        LOG.info("=======接口updateUser已被成功调用=======");
        return result;
    }
}

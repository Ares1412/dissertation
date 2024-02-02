package com.wx.dissertation.service;

import com.wx.dissertation.model.User;

public interface  UserService {

    /**
     * 添加一个新用户，对应用户注册功能
     * @param user
     */
    void addUser(User user);

    /**
     * 删除一个用户，提供给管理员的服务
     * @param id
     */
    void deleteById(String id);

    /**
     * 修改用户信息，对应用户信息更改功能
     * @param user
     */
    void update(User user);

    /**
     * 通过用户名查找用户，对应登录验证服务
     * @param name
     * @return
     */
    User selectByName(String name);
}

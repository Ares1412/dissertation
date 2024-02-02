package com.wx.dissertation.repository;

import com.wx.dissertation.model.User;

public interface UserMapper {
    //添加一个新的用户
    void addUser(User user);
    //通过ID删除用户
    void deleteById(String id);
    //更新用户信息
    void update(User user);
    //通过name查询用户
    User selectByName(String name);
}

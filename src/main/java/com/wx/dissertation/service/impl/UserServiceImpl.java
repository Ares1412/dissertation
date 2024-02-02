package com.wx.dissertation.service.impl;

import com.wx.dissertation.model.User;
import com.wx.dissertation.repository.UserMapper;
import com.wx.dissertation.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void deleteById(String id) {
        userMapper.deleteById(id);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public User selectByName(String name) {
        return userMapper.selectByName(name);
    }
}

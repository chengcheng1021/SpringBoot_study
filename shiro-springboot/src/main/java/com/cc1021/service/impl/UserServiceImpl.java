package com.cc1021.service.impl;

import com.cc1021.mapper.UserMapper;
import com.cc1021.pojo.User;
import com.cc1021.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }
}

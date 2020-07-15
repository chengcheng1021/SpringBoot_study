package com.cc1021.controller;

import com.cc1021.mapper.UserMapper;
import com.cc1021.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    /**
     * 列表
     * @return
     */
    @GetMapping("/queryUserList")
    public List<User> queryUserList() {
        List<User> users = userMapper.queryUserList();
        for (User user : users) {
            System.out.println(user);
        }
        return users;
    }

    /**
     * 新增
     * @return
     */
    @GetMapping("/addUser")
    public String addUser() {
        userMapper.addUser(new User(56, "maomao", "444444"));
        return "ok";
    }
}

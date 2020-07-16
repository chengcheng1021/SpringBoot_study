package com.cc1021.swagger.controller;

import com.cc1021.swagger.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    /**
     * 只要我们的接口中，返回值中存在实体类，就会被扫描到swagger中
     * @return
     */
    @PostMapping("/user")
    public User user() {
        return new User();
    }

    //不是放在类上
    @ApiOperation("Hello2方法")
    @GetMapping("/hello2")
    public String hello2(@ApiParam("用户名") String username) {
        return "hello" + username;
    }
}

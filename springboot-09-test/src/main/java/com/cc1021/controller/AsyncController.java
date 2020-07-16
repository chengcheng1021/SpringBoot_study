package com.cc1021.controller;

import com.cc1021.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    /**
     * 测试异步
     * @return
     */
    @RequestMapping("/hello")
    public String hello() {
        asyncService.hello();   // 停止3秒，转圈
        return "ok";
    }
}

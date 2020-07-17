package com.cc1021.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {


    /**
     * 在一个特定的时间执行这个方法～
     * 秒 分 时 日 月 周～
     */
    @Scheduled(cron = "* * * * * ?")
    public void hello() {
        System.out.println("hello，你被执行了～");
    }
}

package com.cc1021;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootTest
class Springboot09TestApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {

        // 一个简单的邮件～
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setSubject("小刘侨，你好呀～");
        mailMessage.setText("谢谢你哦～");
        mailMessage.setTo("492245711@qq.com");
        mailMessage.setFrom("492245711@qq.com");

        mailSender.send(mailMessage);
    }

}

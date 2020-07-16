package com.cc1021;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

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
        mailMessage.setTo("livfer@163.com");
        mailMessage.setFrom("492245711@qq.com");

        while (true) {
            mailSender.send(mailMessage);
        }
    }

    @Test
    void contextLoads2() throws MessagingException {

        // 一个复杂的邮件～
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // 组装～
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setSubject("你好呀，小🐂🍺～plus");
        helper.setText("<p style='color:red'>这是红色的字</p>", true);

        // 附件～
        helper.addAttachment("1.jpg", new File("/Users/chengcheng/Desktop/avatar.jpg"));
        helper.addAttachment("2.jpg", new File("/Users/chengcheng/Desktop/github.jpg"));
        helper.setTo("livfer@163.com");
        helper.setFrom("492245711@qq.com");

        mailSender.send(mimeMessage);
    }

}

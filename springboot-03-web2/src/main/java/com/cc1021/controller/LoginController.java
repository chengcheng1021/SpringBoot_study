package com.cc1021.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

@Controller
public class LoginController {

    /**
     * 用户登录
     * @param username
     * @param password
     * @param model
     * @return
     */
    @RequestMapping("/user/login")
    //@ResponseBody
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        // 具体的业务
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            return "redirect:/main.html";
        } else {
            // 告诉用户你登录失败了
            model.addAttribute("msg", "用户名或者密码错误");
            return "index";
        }
    }
}

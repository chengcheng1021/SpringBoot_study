package com.cc1021.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

/**
 * 在 templates 目录下的所有页面，只能通过 controller 来跳转！
 * 这个需要模版引擎的支持！thymeleaf
 */
@Controller
public class IndexController {

    @RequestMapping("/test")
    public String test(Model model) {
        model.addAttribute("msg", "<h1>hello,springboot!</h1>");

        model.addAttribute("users", Arrays.asList("cheng","mali"));
        return "test";
    }
}

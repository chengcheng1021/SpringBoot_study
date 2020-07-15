package com.cc1021.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouteController {

    /**
     * 首页
     * @return
     */
    @RequestMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    /**
     * 去登录
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "views/login";
    }

    /**
     * 等级一
     * @param id
     * @return
     */
    @RequestMapping("/level1/{id}")
    public String level1(@PathVariable("id") int id) {
        return "views/level1/"+id;
    }

    /**
     * 等级二
     * @param id
     * @return
     */
    @RequestMapping("/level2/{id}")
    public String level2(@PathVariable("id") int id) {
        return "views/level2/"+id;
    }

    /**
     * 等级三
     * @param id
     * @return
     */
    @RequestMapping("/level3/{id}")
    public String level3(@PathVariable("id") int id) {
        return "views/level3/"+id;
    }
}

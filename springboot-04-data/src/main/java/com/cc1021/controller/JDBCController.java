package com.cc1021.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // 查询数据库的所有信息
    // 没有实体类，数据库中的东西，怎么获取？ Map

    @GetMapping("/userList")
    public List<Map<String, Object>> userList() {
        String sql = "select * from account";

        List<Map<String, Object>> list_maps = jdbcTemplate.queryForList(sql);
        return list_maps;
    }

    @GetMapping("/addUser")
    public String addUser() {
        String sql = "insert into account(id, name, money) values(6,'艳文',1)";
        jdbcTemplate.update(sql);
        return "add-ok";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id) {
        String sql = "update account set name=?, money=? where id="+id;
        // 封装
        Object[] objects = new Object[2];
        objects[0] = "吴艳文";
        objects[1] = 2;
        jdbcTemplate.update(sql, objects);
        return "update-ok";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        String sql = "delete from account where id=?";
        jdbcTemplate.update(sql, id);
        return "delete-ok";
    }

}

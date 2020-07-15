package com.cc1021.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * AOP：拦截器！
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 【授权】
     * 链式编程
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 首页所有人都可以访问，功能页只有对应权限的人才能访问
        // 请求授权的规则～
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        // 没有权限默认会到登录页面，需要开启登录的页面
        // 定制登录页面 toLogin
        http.formLogin().loginPage("/toLogin").usernameParameter("user").passwordParameter("pwd").loginProcessingUrl("/login");

        // 注销，开启了注销功能
        // 防止网站工具：get，post
        http.csrf().disable();  // 关闭csrf功能
        http.logout().logoutSuccessUrl("/");

        // 开启记住我功能，cookie保存，默认2周。自定义前端的参数
        http.rememberMe().rememberMeParameter("remember");
    }

    /**
     * 【认证】
     * springboot 2.1.x 可以直接使用
     * 密码编码：PasswordEncoder
     * 在 Spring Security 5.0+ 中新增了很多的加密方法～
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // 这些数据正常应该从数据库读取

        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("chengcheng").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2", "vip3")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1", "vip2", "vip3")
                .and()
                .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
    }
}

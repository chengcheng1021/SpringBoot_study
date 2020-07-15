package com.cc1021.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DruidConfig {

    /**
     * 将自定义属性绑定到容器中
     * @return
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    /**
     * 后台监控：web.xml
     * 因为SpringBoot 内置了 servlet 容器，所以没有 web.xml，替代方法 ServletRegistrationBean
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        // 后台登录，账号密码
        HashMap<String, String> initParameters = new HashMap<>();

        // 增加配置
        initParameters.put("loginUsername", "admin");
        initParameters.put("loginPassword", "123456");

        // 允许谁可以访问
        initParameters.put("allow", "");

        // 禁止谁能访问
        //initParameters.put("cc1021", "192.168.11.123");

        bean.setInitParameters(initParameters); // 初始化参数
        return bean;
    }

    /**
     * 过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();

        bean.setFilter(new WebStatFilter());

        // 可以过滤哪些请求
        HashMap<String, String> initParameters = new HashMap<>();
        // 这些不进行统计
        initParameters.put("exclusions", "*.js, *.cc, /druid/*");
        bean.setInitParameters(initParameters);
        return bean;
    }

}

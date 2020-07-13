package com.cc1021.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * 拓展 springmvc
 * 如果你想 diy 一些定制化的功能，只要写这个组件，然后将它交给 springboot，就会帮我们自动装配
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    // ViewResolver 实现了视图解析器接口的类，我们就可以把它看作视图解析器

    @Bean
    public ViewResolver myViewResolver() {
        return new MyViewResolver();
    }

    /**
     * 自定义了一个视图解析器
     */
    public static class MyViewResolver implements ViewResolver {
        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }
}

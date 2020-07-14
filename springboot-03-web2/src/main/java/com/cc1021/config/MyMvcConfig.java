package com.cc1021.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

///**
// * 拓展 springmvc
// * 如果你想 diy 一些定制化的功能，只要写这个组件，然后将它交给 springboot，就会帮我们自动装配
// */

/**
 * 如果我们要拓展 springmvc，官方建议我们这样去做
 */
@Configuration
//@EnableWebMvc // 这玩意就是导入了一个类，DelegatingWebMvcConfiguration：从容器中获取所有的 webmvcconfig：
public class MyMvcConfig implements WebMvcConfigurer {

    /**
     * 视图跳转
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/cc1021").setViewName("test");
    }

    //    // ViewResolver 实现了视图解析器接口的类，我们就可以把它看作视图解析器
//
//    @Bean
//    public ViewResolver myViewResolver() {
//        return new MyViewResolver();
//    }
//
//    /**
//     * 自定义了一个视图解析器
//     */
//    public static class MyViewResolver implements ViewResolver {
//        @Override
//        public View resolveViewName(String viewName, Locale locale) throws Exception {
//            return null;
//        }
//    }
}

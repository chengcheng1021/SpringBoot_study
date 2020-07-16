package com.cc1021.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2 // 开启swagger
public class SwaggerConfig {

    /**
     * 配置了 swagger 的 Docker 的 bean实例
     * @return
     */
    @Bean
    public Docket docket(Environment environment) {

        // 设置要显示的swagger环境
        Profiles profiles = Profiles.of("dev", "test");

        // 获取 environment.acceptsProfiles 判断是否处在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                // enable是否启动swagger，如果为false，则swagger不能在浏览器中访问
                .enable(flag)
                .select()
                // RequestHandlerSelectors，配置要扫描的接口方式
                // basePackage：指定要扫描的包
                // any()：扫描全部
                // none()：都不扫描
                // withClassAnnotation：扫描类上的注解，参数是一个注解的反射对象
                // withMethodAnnotation：扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.cc1021.swagger.controller"))
                //.paths(PathSelectors.ant("/cc1021/**"))
                .build();
    }

    /**
     * 配置 swagger 信息 apiInfo
     * @return
     */
    private ApiInfo apiInfo() {

        // 作者信息
        Contact contact = new Contact("🍊", "https://cc1021.com", "492245711@qq.com");

        return new ApiInfo(
                "🍊的SwaggerAPI文档",
                "5200w",
                "v9.9",
                "https://cc1021.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );
    }
}

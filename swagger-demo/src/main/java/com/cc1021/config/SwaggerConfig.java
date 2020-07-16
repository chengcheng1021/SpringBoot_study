package com.cc1021.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

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

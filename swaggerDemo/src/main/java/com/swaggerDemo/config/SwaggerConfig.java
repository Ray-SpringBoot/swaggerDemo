package com.swaggerDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableOpenApi
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30) //設置使用 OpenApi 3.0 規範
                //是否開啟Swagger
                .enable(true)
                //配置項目基本訊息
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //文檔標題
                .title("swagger demo 接口")
                //文檔描述
                .description("swagger practice")
                //文檔版本
                .version("1.0")
                //.contact(new Contact("back-end", "url", "email"))
                .build();
    }
}

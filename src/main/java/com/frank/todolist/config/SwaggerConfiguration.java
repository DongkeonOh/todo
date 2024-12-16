package com.frank.todolist.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfiguration {
    private static final String API_NAME = "To-Do Project APIs";
    private static final String API_VERSION = "1.0.0";
    private static final String API_DESCRIPTION = "To-Do Project API 명세";

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()) //apiInfo() 메서드로부터 반환되는 ApiInfo 객체를 사용하여 API의 메타데이터(제목, 버전, 설명 등)를 설정
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.frank.todolist.controller"))   //API 문서화를 위해 스캔할 대상을 선택
                .paths(PathSelectors.any())
                .build();
    }

    // apiInfo() 메서드에서는 API 문서의 제목, 버전, 설명 등을 설정한 후 ApiInfo 객체를 반환
    // 이 설정은 Swagger UI를 통해 API 문서를 생성하고 표시하는 데 사용됨
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(API_NAME)
                .version(API_VERSION)
                .description(API_DESCRIPTION)
                .build();
    }
}

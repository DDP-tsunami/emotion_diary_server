package com.dadaepo.emo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.swing.text.Document;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket swagger() {
        return new Docket(DocumentationType.SWAGGER_2)
                .ignoredParameterTypes(java.sql.Date.class)
                .forCodeGeneration(true)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .enable(true);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("이모션 API")
                .build();
    }
}

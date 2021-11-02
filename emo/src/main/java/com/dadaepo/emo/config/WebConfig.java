package com.dadaepo.emo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // CORS를 적용할 URL 패턴 정의
                .allowedOrigins("*")   // 자원 공유를 허락할 Origin 지정
                .allowedMethods("*")   // 모든 HTTP method 허락
                .maxAge(3000);  // 원하는 시간만큼 pre-flight 리퀴스트를 캐싱
    }
}
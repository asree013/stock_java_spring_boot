package com.asree.stock_spring_boot.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // หรือกำหนดให้เฉพาะเส้นทางที่ต้องการ
                .allowedOrigins("http://localhost:3000") // หรือโดเมนที่คุณต้องการอนุญาต
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // กำหนด HTTP methods ที่อนุญาต
                .allowedHeaders("*") // อนุญาตทุก headers
                .allowCredentials(true); // หากคุณต้องการอนุญาต cookies หรือ HTTP authentication
    }
}

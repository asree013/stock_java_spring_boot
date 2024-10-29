package com.asree.stock_spring_boot.configs;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.asree.stock_spring_boot.repositorys")
@EntityScan(basePackages = "com.asree.stock_spring_boot.models")
@EnableTransactionManagement

public class JpaConfig {
    // ที่นี่คุณสามารถเพิ่ม Bean อื่น ๆ ถ้าจำเป็น
}

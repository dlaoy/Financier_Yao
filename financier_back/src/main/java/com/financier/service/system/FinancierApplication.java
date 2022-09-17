package com.financier.service.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.financier")
public class FinancierApplication {
    public static void main(String[] args) {
        SpringApplication.run(FinancierApplication.class, args);
    }
}

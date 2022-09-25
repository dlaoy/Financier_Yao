package com.financier.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author enrace
 */
@SpringBootApplication
@MapperScan("com.financier")
//@ServletComponentScan(basePackages = "com.financier.system.aspect.filter")
public class FinancierApplication {
    public static void main(String[] args) {
        SpringApplication.run(FinancierApplication.class, args);
    }
}

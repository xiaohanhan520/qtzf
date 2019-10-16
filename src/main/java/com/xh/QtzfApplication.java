package com.xh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.xh.dao")
public class QtzfApplication {

    public static void main(String[] args) {
        SpringApplication.run(QtzfApplication.class, args);
    }

}

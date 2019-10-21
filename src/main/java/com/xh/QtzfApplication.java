package com.xh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.xh.dao")
public class QtzfApplication {

    public static void main(String[] args) {
        SpringApplication.run(QtzfApplication.class, args);
    }

}

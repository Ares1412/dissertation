package com.wx.dissertation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wx.dissertation.repository")
public class DissertationApplication {

    public static void main(String[] args) {
        SpringApplication.run(DissertationApplication.class, args);
    }

}

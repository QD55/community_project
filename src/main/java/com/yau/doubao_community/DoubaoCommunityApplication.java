package com.yau.doubao_community;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.yau.doubao_community.mapper")
@SpringBootApplication
public class DoubaoCommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoubaoCommunityApplication.class, args);
    }

}

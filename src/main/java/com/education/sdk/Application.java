package com.education.sdk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;
/**
* @description: 主启动类
* @author: wuming
* @create: 2025.02.28 10:20:21
*/
@MapperScan("com.education.sdk.dao")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

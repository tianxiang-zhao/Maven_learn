package com.idea.spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/*
* @ImportResource(locations = {"classpath:beans.xml"})  加载spring xml 文件
* */
@ImportResource(locations = {"classpath:beans.xml"})
@SpringBootApplication
public class SpringBootConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConfigApplication.class, args);
    }

}

package com.idea.spring_boot.config;


import com.idea.spring_boot.Service.helloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
* @Configuration 指明当前类是一个配置类，代替之前的spring配置文件
* */
@Configuration
public class myConfig {
    @Bean
    public helloService helloService02(){
        System.out.println("配置类@bean 给容器添加了组件");
        return  new helloService();
    }

}

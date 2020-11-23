package com.idea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//来标注这是一个springboot主程序
@SpringBootApplication
public class HelloWordMain {
    public static  void  main(String args[]){
        //Spring应用启动起来
        SpringApplication.run(HelloWordMain.class,args);

    }
}

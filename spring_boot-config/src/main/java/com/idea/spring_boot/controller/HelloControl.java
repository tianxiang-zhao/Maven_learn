package com.idea.spring_boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControl {
    @Value("${person.last-name}")
  private  String name;
    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello"+name;
    }
}

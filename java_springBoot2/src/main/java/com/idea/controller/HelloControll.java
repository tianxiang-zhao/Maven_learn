package com.idea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
/*@RestController*/
public class HelloControll {
    @ResponseBody//表示将返回的数据给浏览器；如果加载类名上 该类下所有的方法都会将返回值返回给浏览器（如果是对象还能转换为json数据）
    @RequestMapping("/hello")

    public String hello(){
        return "Hello World";
    }
}

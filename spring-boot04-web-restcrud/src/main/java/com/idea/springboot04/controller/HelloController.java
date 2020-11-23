package com.idea.springboot04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {
    //@ResponseBody 可以将返回值打印到页面
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }


    @RequestMapping("/success")
    public String success(){
        return "success";
    }

    @RequestMapping("/index.html")
    public String index(){
        return "index";
    }
}

package com.idea.springboot04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;


import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping(value = "/login")
    public  String login(@RequestParam("username") String UserName,
                         @RequestParam("password") String PassWord,
                         Map<String,Object> map, HttpSession session){

        System.out.println(UserName);
        System.out.println(PassWord);
        if(PassWord.equals("123456"))
        {

            session.setAttribute("loginUserName",UserName);
            System.out.println("密码正确");

            //防止重复提交  进行重定向
            return "redirect:/main.html";
        }
        else{
            System.out.println("密码错误");
            map.put("msg","用户名或密码错误！");
            return "index";
        }

    }
}

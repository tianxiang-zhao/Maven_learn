package com.idea.springboot04.controller;

import com.idea.springboot04.exception.UserNoExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
@ControllerAdvice
public class UserExceptionHandler {


    //这种浏览器 和 客户端返回的都是json格式数据
//    @ResponseBody
//    @ExceptionHandler(UserNoExistException.class)
//    public Map<String,Object> handleException(Exception e){
//        Map<String,Object> map=new HashMap<>();
//        map.put("code","user.notexist");
//        map.put("message",e.getMessage());
//        return map;
//
//    }

    @ExceptionHandler(UserNoExistException.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        //传入我们自己的错误状态码子
        //否做不会进入定制错误页面
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        //将其放入request.setAttribute 然后在 component中使用
        request.setAttribute("ext",map);
        //转发到error 然后让springboot进行自适应处理
        return "forward:/error";

 }

}

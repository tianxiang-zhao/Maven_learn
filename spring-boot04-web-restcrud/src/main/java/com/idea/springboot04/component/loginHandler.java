package com.idea.springboot04.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//登陆拦截器
public class loginHandler implements HandlerInterceptor {
    @Override
    //目标方法执行之前
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser=request.getSession().getAttribute("loginUserName");
        if (loginUser==null){
            //没有登陆的访问  需要拦截掉  并将其转发到登陆界面
            request.setAttribute("meg","没有访问权限");
            request.getRequestDispatcher("/index").forward(request,response);
            return false;
        }

        else{
                return true;
        }


    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

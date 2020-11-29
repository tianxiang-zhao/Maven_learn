package com.idea.springboot04.myfailter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

public class MyFilter extends HttpFilter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilter Process....");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}

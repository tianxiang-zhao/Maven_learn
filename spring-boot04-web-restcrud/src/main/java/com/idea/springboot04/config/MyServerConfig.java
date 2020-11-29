package com.idea.springboot04.config;

import com.idea.springboot04.listener.MyListener;
import com.idea.springboot04.myfailter.MyFilter;
import com.idea.springboot04.servlet.MyServlet;
import com.sun.xml.internal.ws.handler.ServerLogicalHandlerTube;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRegistration;
import java.util.Arrays;

//配置Servlet
@Configuration
public class MyServerConfig {
    //注册三大组件
    @Bean
public ServletRegistrationBean myServlet(){
    ServletRegistrationBean registrationBean=new ServletRegistrationBean(new MyServlet());
    return registrationBean;
}
@Bean
public FilterRegistrationBean myFilter(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/MyServlet"));//需要对那些请求进行拦截处理
        return filterRegistrationBean;
}
@Bean
public ServletListenerRegistrationBean servletListenerRegistrationBean(){
//        ServletListenerRegistrationBean servletListenerRegistrationBean=new ServletListenerRegistrationBean();
//        servletListenerRegistrationBean.setListener(new MyListener());

    ServletListenerRegistrationBean<MyListener> servletListenerRegistrationBean=new ServletListenerRegistrationBean<>(new MyListener());
    return servletListenerRegistrationBean;
}



// 定制嵌入式的Servlet容器相关规则。
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> configurableWebServerFactory() {
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8080);
            }
        };
    }
}

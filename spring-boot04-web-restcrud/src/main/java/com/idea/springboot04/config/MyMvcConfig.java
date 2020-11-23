package com.idea.springboot04.config;



import com.idea.springboot04.component.LocalResolver;
import com.idea.springboot04.component.loginHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");//将sdf转到success
        registry.addViewController("/main.html").setViewName("dashboard");
    }


    //将自己的拦截器注册进去
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns("/**") 拦截的请求 /**表示拦截所有请求
        //excludePathPatterns()  排除一些 不用验证的请求
        //静态资源  css js springboot已经做好了静态资源映射
        registry.addInterceptor(new loginHandler()).addPathPatterns("/**").excludePathPatterns("/index","/","/login");
    }

    @Bean  //将地域解析组建注册进去使用自己的
    public LocaleResolver  localeResolver(){
        return new LocalResolver();
    }
}

package com.idea.springboot04.component;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
//让springboot使用自己的组件  区域信息解析器


public class LocalResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {

       String l= httpServletRequest.getParameter("l");
       Locale locale=Locale.getDefault();//链接是否带有区域信息
       if (!StringUtils.isEmpty(l)){
            String[] split=l.split("_");
            locale=new Locale(split[0],split[1]);

        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}

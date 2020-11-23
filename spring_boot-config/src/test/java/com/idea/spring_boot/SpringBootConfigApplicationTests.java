package com.idea.spring_boot;

import com.idea.spring_boot.bean.Person;
import javafx.application.Application;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import sun.security.util.Length;

@SpringBootTest
class SpringBootConfigApplicationTests {

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;
    @Test
    void contextLoads() {
        System.out.println(person);
    }
    @Test
    void testHelloService(){

        /*
        * 需要使用@ImportResource(locations = {"classpath:beans.xml"}) 在Application中配置
        * */
//        boolean b=ioc.containsBean("helloService"); 使用@ImportResource(locations = {"classpath:beans.xml"})
        boolean b=ioc.containsBean("helloService02");//使用@bean
        System.out.println(b);
    }
    void reverse(int b[]){
        int []c=new int[b.length];
        for(int i=0;i<b.length;i++){
            c[i]=b[b.length-1-i];
        }
        b=c;

    }
    @Test
    void testArray(){
        int []a={1,2,3,4,5};
        reverse(a);
        System.out.println(a[0]);
    }

}

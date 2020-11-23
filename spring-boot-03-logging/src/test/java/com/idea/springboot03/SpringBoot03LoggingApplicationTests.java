package com.idea.springboot03;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SpringBoot03LoggingApplicationTests {
    //记录器
    Logger logger= LoggerFactory.getLogger(getClass());
    @Test
    void contextLoads() {
        //日志级别又低到高
        //可以调整输入测日志级别

      logger.trace("这是trace日志");//可以在配置文件中配置日志级别
      logger.debug("这是debug日志");
      //springboot的默认级别是info，只输出级别比默认级别相等或高的。
      logger.info("这是info信息");
      logger.warn("这是warn信息");
      logger.error("这是error信息");
    }

}

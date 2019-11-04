package com.johar.springcloud.feigndemo;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: HelloFeignServiceConfig
 * @Description: TODO
 * @Author: Johar
 * @Date: 2019/10/15 23:13
 * @Version: 1.0
 */
@Configuration
public class HelloFeignServiceConfig {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}

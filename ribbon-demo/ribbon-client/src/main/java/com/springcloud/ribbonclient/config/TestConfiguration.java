package com.springcloud.ribbonclient.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: TestConfiguration
 * @Description: TODO
 * @Author: Johar
 * @Date: 2019/10/26 22:52
 * @Version: 1.0
 */
//@Configuration
public class TestConfiguration {

    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}

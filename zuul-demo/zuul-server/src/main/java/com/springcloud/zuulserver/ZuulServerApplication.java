package com.springcloud.zuulserver;

import com.springcloud.zuulserver.filter.FirstPreFilter;
import com.springcloud.zuulserver.filter.PostFilter;
import com.springcloud.zuulserver.filter.SecondFilter;
import com.springcloud.zuulserver.filter.ThirdPreFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class, args);
    }

    @Bean
    public FirstPreFilter firstPreFilter(){
        return new FirstPreFilter();
    }

    @Bean
    public SecondFilter secondFilter(){
        return new SecondFilter();
    }

    @Bean
    public ThirdPreFilter thirdPreFilter(){
        return new ThirdPreFilter();
    }

    @Bean
    public PostFilter postFilter(){
        return new PostFilter();
    }
}

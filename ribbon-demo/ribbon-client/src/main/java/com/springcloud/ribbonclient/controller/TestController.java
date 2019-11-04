package com.springcloud.ribbonclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: TestController
 * @Description: TODO
 * @Author: Johar
 * @Date: 2019/10/26 08:49
 * @Version: 1.0
 */
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/add")
    public String add(Integer a, Integer b){
        String result = restTemplate.getForObject("http://eureka-client/add?a=" + a + "&b=" + b, String.class);
        System.out.println(result);
        return result;
    }
}

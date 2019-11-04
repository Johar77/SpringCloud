package com.springcloud.clienta.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TestController
 * @Description: TODO
 * @Author: Johar
 * @Date: 2019/10/27 18:10
 * @Version: 1.0
 */
@RestController
public class TestController {

    @GetMapping("/add")
    public Integer add(Integer a, Integer b){
        return a + b;
    }
}

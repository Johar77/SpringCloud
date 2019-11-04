package com.springcloud.clienta.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TestContoller
 * @Description: TODO
 * @Author: Johar
 * @Date: 2019/10/28 23:46
 * @Version: 1.0
 */
@RestController
public class TestContoller {

    @GetMapping("/add")
    public Integer add(Integer a, Integer b){
        return a + b;
    }

    @GetMapping("/a/add")
    public Integer aadd(Integer a, Integer b){
        return a + b;
    }

    @GetMapping("/sub")
    public Integer sub(Integer a, Integer b){
        return a - b;
    }

    @GetMapping("/mul")
    public String mul(Integer a, Integer b){
        System.out.println("进入client-a!");
        return "client-a-" + a * b;
    }

    @GetMapping("/div")
    public Integer div(Integer a, Integer b){
        return a / b;
    }
}


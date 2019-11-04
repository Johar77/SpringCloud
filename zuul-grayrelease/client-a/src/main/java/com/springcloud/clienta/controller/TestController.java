package com.springcloud.clienta.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: TestController
 * @Description: TODO
 * @Author: Johar
 * @Date: 2019/10/30 08:41
 * @Version: 1.0
 */
@RestController
public class TestController {
    @GetMapping("/add")
    public String add(Integer a, Integer b, HttpServletRequest request){
        return "service client-a, port: " + request.getServerPort() + ", result=" + (a + b);
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

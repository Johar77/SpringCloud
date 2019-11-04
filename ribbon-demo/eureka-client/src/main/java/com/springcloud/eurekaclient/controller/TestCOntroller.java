package com.springcloud.eurekaclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: TestCOntroller
 * @Description: TODO
 * @Author: Johar
 * @Date: 2019/10/26 08:37
 * @Version: 1.0
 */
@RestController
public class TestCOntroller {

    @GetMapping("/add")
    public String add(Integer a, Integer b, HttpServletRequest request){
        return " From Port " + request.getServerPort() + ", Result: " + (a + b);
    }
}

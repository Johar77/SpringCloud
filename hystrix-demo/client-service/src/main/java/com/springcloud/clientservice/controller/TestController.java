package com.springcloud.clientservice.controller;

import com.springcloud.clientservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TestController
 * @Description: TODO
 * @Author: Johar
 * @Date: 2019/10/27 11:14
 * @Version: 1.0
 */
@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String getUser(@RequestParam String username) throws Exception{
        return userService.getUser(username);
    }
}

package com.springcloud.consumerservice.controller;

import com.springcloud.consumerservice.service.IUserService;
import com.springcloud.consumerservice.service.impl.UserServiceFallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: TestController
 * @Description: TODO
 * @Author: Johar
 * @Date: 2019/10/27 15:55
 * @Version: 1.0
 */
@RestController
public class TestController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public String getUser(@RequestParam("username") String username){
        return userService.getUser(username);
    }

    @GetMapping("/getProviderData")
    public List<String> getProviderData(){
        return userService.getProviderData();
    }
}

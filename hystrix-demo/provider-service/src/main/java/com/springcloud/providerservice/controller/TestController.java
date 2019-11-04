package com.springcloud.providerservice.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: TestController
 * @Description: TODO
 * @Author: Johar
 * @Date: 2019/10/27 15:26
 * @Version: 1.0
 */
@RestController
public class TestController {
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public String getUser(@RequestParam("username") String username) throws Exception{
        if ("spring".equals(username)){
            return "This is a real user.";
        } else{
            throw new Exception();
        }
    }

    @GetMapping("/getProviderData")
    public List<String> getProviderData(){
        List<String> provider = new ArrayList<>();
        provider.add("hystrix dashbord");
        return provider;
    }
}

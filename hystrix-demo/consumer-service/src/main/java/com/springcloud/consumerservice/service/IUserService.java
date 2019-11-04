package com.springcloud.consumerservice.service;

import com.springcloud.consumerservice.service.impl.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johar
 */
@FeignClient(name = "sc-provider-service", fallback = UserServiceFallback.class)
public interface IUserService {

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public String getUser(@RequestParam("username") String username);

    @GetMapping("/getProviderData")
    public List<String> getProviderData();
}

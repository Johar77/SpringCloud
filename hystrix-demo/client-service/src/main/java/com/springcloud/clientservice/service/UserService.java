package com.springcloud.clientservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @Author: Johar
 * @Date: 2019/10/27 10:53
 * @Version: 1.0
 */
@Service
public class UserService{

    @HystrixCommand(fallbackMethod = "defaultUser")
    public String getUser(String username) throws Exception{
        if (username.equals("spring")){
            return "this is real user";
        } else{
            throw new Exception();
        }
    }

    public String defaultUser(String username){
        return "The user does not exit in this system";
    }
}

package com.springcloud.consumerservice.service.impl;

import com.springcloud.consumerservice.service.IUserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: UserServiceFallback
 * @Description: TODO
 * @Author: Johar
 * @Date: 2019/10/27 15:55
 * @Version: 1.0
 */
@Component("userService")
public class UserServiceFallback implements IUserService {
    @Override
    public String getUser(String username) {
        return "The user does not exit in this system, please confirm username.";
    }

    @Override
    public List<String> getProviderData() {
        return new ArrayList<>();
    }
}

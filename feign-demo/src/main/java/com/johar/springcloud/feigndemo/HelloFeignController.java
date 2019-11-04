package com.johar.springcloud.feigndemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloFeignController
 * @Description: TODO
 * @Author: Johar
 * @Date: 2019/10/15 23:03
 * @Version: 1.0
 */
@RestController
@Slf4j
public class HelloFeignController {

    @Autowired
    private HelloFeignService helloFeignService;

    @GetMapping(value = "/search/github")
    public String searchGithubRepoByStr(@RequestParam("str") String queryStr){
        return helloFeignService.searchRepo(queryStr);
    }
}

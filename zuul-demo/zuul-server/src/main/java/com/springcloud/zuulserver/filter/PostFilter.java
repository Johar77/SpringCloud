package com.springcloud.zuulserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;

/**
 * @ClassName: PostFilter
 * @Description: TODO
 * @Author: Johar
 * @Date: 2019/10/28 08:14
 * @Version: 1.0
 */
public class PostFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("This is the post filter.");
        RequestContext context = RequestContext.getCurrentContext();
        context.getResponse().setCharacterEncoding("UTF-8");
        String responseBody = context.getResponseBody();
        if (responseBody != null){
            context.setResponseStatusCode(500);
            context.setResponseBody(responseBody);
        }

        return null;
    }
}

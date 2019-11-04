package com.springcloud.zuulserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @ClassName: SecondFilter
 * @Description: TODO
 * @Author: Johar
 * @Date: 2019/10/28 08:13
 * @Version: 1.0
 */
public class SecondFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("This is the second pre filter.");
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String a = request.getParameter("a");
        if (a == null) {
            context.setSendZuulResponse(false);
            context.setResponseBody("{\"status\":500, \"message\":\"a参数为空\"}");
            context.set("logic-is-success", false);
            return null;
        }
        context.set("logic-is-success", true);
        return null;
    }
}

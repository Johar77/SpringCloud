package com.springcloud.zuulserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @ClassName: ThirdPreFilter
 * @Description: TODO
 * @Author: Johar
 * @Date: 2019/10/28 08:13
 * @Version: 1.0
 */
public class ThirdPreFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 3;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        return (boolean)context.get("logic-is-success");
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("This is the third pre filter.");
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String b = request.getParameter("b");
        if (b == null){
            context.setSendZuulResponse(false);
            context.setResponseBody("{\"status\":500, \"message\":\"b参数为空\"}");
            context.set("logic-is-success", false);
            return null;
        }
        context.set("logic-is-success", true);
        return null;
    }
}

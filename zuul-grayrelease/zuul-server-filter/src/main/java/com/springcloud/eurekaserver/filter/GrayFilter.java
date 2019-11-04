package com.springcloud.eurekaserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

/**
 * @ClassName: GrayFilter
 * @Description: TODO
 * @Author: Johar
 * @Date: 2019/10/30 22:43
 * @Version: 1.0
 */
public class GrayFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        return !context.containsKey(FORWARD_TO_KEY) && !context.containsKey(SERVICE_ID_KEY);
    }

    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String mark = request.getHeader("gray_mark");
        System.out.println("gray_mark: " + mark);
        if (!StringUtils.isEmpty(mark) && "enable".equals(mark)){
            RibbonFilterContextHolder.getCurrentContext().add("host-mark", "gray-host");
        } else {
            RibbonFilterContextHolder.getCurrentContext().add("host-mark", "running-host");
        }
        return null;
    }
}

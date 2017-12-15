package com.cbcing.springcloudzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * Zuul 过滤器
 */
@Slf4j
public class AccessFilter extends ZuulFilter {

    /**
     * 过滤器类型，决定过滤器在请求的那个生命周期执行。
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行顺序：当请求的一个阶段中存在多个过滤器时，需要根据该方法的返回值来依次执行。
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断过滤器是否需要被执行。
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器具体的逻辑。
     * @return
     */
    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();

        log.info("send {} request to {}", httpServletRequest.getMethod(), httpServletRequest.getRequestURL().toString());

        Object accessToken = httpServletRequest.getParameter("accessToken");
        if (accessToken == null) {
            log.warn("access token is empty.");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            return null;
        }
        log.info("access token is ok");

        return null;
    }
}

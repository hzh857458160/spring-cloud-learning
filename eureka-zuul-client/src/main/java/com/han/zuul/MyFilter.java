package com.han.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @author Czbank-Han
 *  filterType分为四种:"pre","post","routing","error"
 *  filterOrder为过滤顺序，数值越小越早执行
 *  shouldFilter为是否过滤，是则执行run()
 *  run为过滤逻辑
 *
 */
@Component
public class MyFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;
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
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        Object accessToken = request.getParameter("token");
        if (!"HanrAx".equals(accessToken)) {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            try {
                requestContext.getResponse().getWriter().write("invalid token");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

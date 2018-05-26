package com.cloud.service.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulAuthFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(ZuulAuthFilter.class);
    
	@Override
	public String filterType() {
		
		/**
		 * 
		 *    pre：可以在请求被路由之前调用
		 *	  route：在路由请求时候被调用
    	 *    post：在route和error过滤器之后被调用
         *    error：处理请求时发生错误时被调用
		 * 
		 */
		return "pre";
	}
	
	@Override
	public int filterOrder() {
		// 通过int值来定义过滤器的执行顺序
		return 0;
	}
	
	@Override
	public boolean shouldFilter() {
		// boolean类型来判断该过滤器是否要执行
		return true;
	}
	
	@Override
	public Object run() {
		
		// 过滤器的具体逻辑
		RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}
            return null;
        }
        log.info("ok");
        return null;
	}

    
}


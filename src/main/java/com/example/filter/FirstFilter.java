package com.example.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Administrator on 2018/9/13 0013.
 */
@Component
@Order(3)
public class FirstFilter implements MyFilter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("firstFilter init run....");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("firstFilter doFilter run...");
        servletRequest.setAttribute("first",true);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }

}

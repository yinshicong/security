package com.example.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Administrator on 2018/9/13 0013.
 */
@Component
@Order(4)
public class AfterFilter implements IAfterFilter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("AfterFilter init run...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("AfterFilter init run...");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

package com.example.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Administrator on 2018/9/13 0013.
 */
@Component
@Order(2)
public class BeforeFilter implements IBeforeFilter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("BeforeFilter init run...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("BeforeFilter doFilter run...");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }

}

package com.example.config;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 *  该方法只有访问失败才会进入，所以未登录情况下，并不会触发该方法
 *
 *  比如登录了，但是访问了一个自己不能访问的地址就判定为访问失败，就会触发方法。
 *
 * Created by Administrator on 2018/9/13 0013.
 */
@Component
public class AdminAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        System.out.println("handle run...url="+httpServletRequest.getRequestURL());
    }

}

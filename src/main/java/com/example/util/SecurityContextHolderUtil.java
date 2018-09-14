package com.example.util;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 *
 * Created by Administrator on 2018/9/13 0013.
 */
public class SecurityContextHolderUtil {


    /**
     * SecurityContextHolder是SpringSecurity最基本的组件了，是用来存放SecurityContext的对象，默认是使用ThreadLocal实现的，这样就保证了本线程内所有的 方法都可以获得SecurityContext对象。
     * @param user
     */
    public static void setCurrentUser(User user){
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user.getUsername(), null, user.getAuthorities());
        authentication.setDetails(user);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    public static User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getDetails() == null ? null : (User)authentication.getDetails();
    }

}

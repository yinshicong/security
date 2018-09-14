package com.example.controller;

import com.example.util.SecurityContextHolderUtil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/13 0013.
 */
@RestController
@RequestMapping
public class LoginController {

    @GetMapping("/login/{username}/{pwd}")
    public String login(
            @PathVariable String username,
            @PathVariable String pwd

    ){

        List<GrantedAuthority> authorities = new ArrayList<>();
        //创建权限
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
        authorities.add(simpleGrantedAuthority);
        //创建用户
        User user = new User(username,pwd,authorities);
        //存储当前登录对象
        SecurityContextHolderUtil.setCurrentUser(user);
        return "redirect:/admin/hello";

    }



}

package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/9/13 0013.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("hello")
    public String user(){
        return "hello user center";
    }

}

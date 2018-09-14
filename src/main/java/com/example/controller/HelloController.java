package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/9/10 0010.
 */
@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("hello")
    public String hello(){
        return "hello security";
    }

}

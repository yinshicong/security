package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/9/13 0013.
 */
@RestController
public class HomeController {

    @GetMapping("hello")
    public String hello(){
        return "hello~~";
    }

}

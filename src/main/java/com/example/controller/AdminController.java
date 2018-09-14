package com.example.controller;

import com.example.util.SecurityContextHolderUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/9/13 0013.
 */
@RestController()
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("hello")
    private String admin(){

//        return "hello admin" ;
        return "hello admin-" + SecurityContextHolderUtil.getCurrentUser().getUsername();
    }

}

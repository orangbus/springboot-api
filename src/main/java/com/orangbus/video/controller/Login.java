package com.orangbus.video.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Login {

    /**
     * 登录
     */
    @GetMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password
    ){
        return "login";
    }

    /**
     * 注册
     */
    @GetMapping("register")
    public String register(){
        return "register";
    }
}

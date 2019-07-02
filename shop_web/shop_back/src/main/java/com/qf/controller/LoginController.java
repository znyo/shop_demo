package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
public class LoginController {
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    /*登录*/
    @RequestMapping("/login")
    public String login(){
        return "index";
    }
}

package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.service.IBackUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("loginUser")
public class LoginController {
@Reference
    private IBackUserService userService;
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
 /*   *//*登录*//*
    @RequestMapping("/login")
    public String login(String username, String password, Model model){
        System.out.println(username+password);
        BackUser user = userService.login(username, password);

        if(user != null){
            //登录成功 - 放入session中
            model.addAttribute("loginUser", user);
            System.out.println(user);
            return "index";
        }
        return "redirect:/toLogin?error=1";
    }*/
}

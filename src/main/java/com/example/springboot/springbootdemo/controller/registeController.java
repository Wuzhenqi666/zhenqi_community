package com.example.springboot.springbootdemo.controller;

import com.example.springboot.springbootdemo.service.UserService;
import com.example.springboot.springbootdemo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class registeController {

    private UserServiceImpl userService;

    @GetMapping("/registe")
   public String registe(){
        return "registe";
    }
    @GetMapping("/registePost")
    public String registePost(@RequestParam(value = "用户名")String name,@RequestParam(value = "密码")String password,@RequestParam(value = "邮箱")String email,@RequestParam("手机")String phonenumber){
        userService.registeSucess();
        return "redirect:index";
    }
}

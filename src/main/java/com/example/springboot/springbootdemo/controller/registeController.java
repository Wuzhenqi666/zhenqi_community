package com.example.springboot.springbootdemo.controller;

import com.example.springboot.springbootdemo.dto.UserDto.User;
import com.example.springboot.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
public class registeController {

    @Autowired
    private UserService userService;

    @GetMapping("/registe")
   public String registe(){
        return "registe";
    }

    @RequestMapping(value="/registePost",method=RequestMethod.POST)
    public String registePost(User user) {

            userService.registeUser(user);
            System.out.println("注册"+user);
        return "index";
    }
}

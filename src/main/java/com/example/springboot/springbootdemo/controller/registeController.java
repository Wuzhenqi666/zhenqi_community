package com.example.springboot.springbootdemo.controller;

import com.example.springboot.springbootdemo.dto.UserDto.User;
import com.example.springboot.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Controller
public class registeController {

    @Autowired
    private UserService userService;

    @GetMapping("/registe")
   public String registe(){
        return "registe";
    }

    @RequestMapping(value="registePost",method=RequestMethod.POST)
    public boolean registePost(@RequestParam("exampleInputUsername1")String name, @RequestParam("exampleInputPassword1")String password, @RequestParam("exampleInputEmail1")String email, @RequestParam("exampleInputPhone1")String phone, HttpServletRequest request) {
            User user = new User();
            user.setLastIp(request.getLocalAddr());
            user.setLastVisit(new Date());
            user.setUserEmail(email);
            user.setUserName(name);
            user.setUserPassword(password);
            user.setUserPhonenumber(phone);
            userService.registeUser(user);
            System.out.println(user.toString());
        return true;
    }
}

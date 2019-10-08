package com.example.springboot.springbootdemo.controller;

import com.example.springboot.springbootdemo.dto.UserDto.User;
import com.example.springboot.springbootdemo.model.token.TokenModel;
import com.example.springboot.springbootdemo.model.tokenImpl.RedisTokenManager;
import com.example.springboot.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class loginController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTokenManager redisTokenManager;

    @Autowired
    private TokenModel tokenModel;

    @RequestMapping(value = "/loginIndex",method = RequestMethod.POST)
    public String login(User user, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        System.out.println(user);
        if(userService.loginService(user)){
            userService.loginSuccess(user);
            tokenModel = redisTokenManager.createToken(user.getUserId());
            httpServletResponse.addCookie(new Cookie("token",tokenModel.getToken()));
            return "index";
        }else{
            return "index";
        }

    }
    @RequestMapping(value = "/login")
    public String loginIndex(){
        return "loginIndex";
    }


}

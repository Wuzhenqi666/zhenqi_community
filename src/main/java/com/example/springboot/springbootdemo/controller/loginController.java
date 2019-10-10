package com.example.springboot.springbootdemo.controller;

import com.example.springboot.springbootdemo.dto.UserDto.User;
import com.example.springboot.springbootdemo.model.token.TokenModel;
import com.example.springboot.springbootdemo.model.tokenImpl.RedisTokenManager;
import com.example.springboot.springbootdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private User user;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTokenManager redisTokenManager;

    @Autowired
    private TokenModel tokenModel;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/loginIndex",method = RequestMethod.POST)
    public String login(User user, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        this.user = userService.loginService(user);
        if(this.user!=null){
            userService.loginSuccess(this.user);
           logger.info("更新积分"+this.user);
            tokenModel = redisTokenManager.createToken(this.user.getUserId());
            httpServletResponse.addCookie(new Cookie("token",tokenModel.getToken()));
            System.out.println(tokenModel.getToken());
            httpServletRequest.getSession().setAttribute("user",this.user);
            return "index";
        }else{
            return "loginIndex";
        }

    }
    @RequestMapping(value = "/login")
    public String loginIndex(){
        return "loginIndex";
    }


}

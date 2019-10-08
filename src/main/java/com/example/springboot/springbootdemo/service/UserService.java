package com.example.springboot.springbootdemo.service;
import com.example.springboot.springbootdemo.dto.UserDto.User;


public  interface UserService {
     boolean  registeUser(User user);
     boolean loginSuccess(User user);
     boolean loginService(User user);
}

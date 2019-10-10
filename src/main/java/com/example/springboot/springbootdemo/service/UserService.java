package com.example.springboot.springbootdemo.service;
import com.example.springboot.springbootdemo.dto.UserDto.User;



public  interface UserService {
     boolean  registeUser(User user);
     User loginSuccess(User user);
     User loginService(User user);
}

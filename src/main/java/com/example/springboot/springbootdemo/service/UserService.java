package com.example.springboot.springbootdemo.service;

import com.example.springboot.springbootdemo.dto.UserDto.User;

public interface UserService {
    void loginSuccess(String userName,String userPassword);
    User findUserByUserName(String userName);
    void updateUserInf(User user);
    void registeSucess();
}

package com.example.springboot.springbootdemo.dao.UserDao;

import com.example.springboot.springbootdemo.dto.UserDto.User;

public interface UserAbstractDao {
    void loginSuccess(String userName,String userPassword);
    User findUserByUserName(String userName);
    void updateUserInf(User user);
}

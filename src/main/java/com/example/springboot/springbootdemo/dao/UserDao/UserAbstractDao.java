package com.example.springboot.springbootdemo.dao.UserDao;

import com.example.springboot.springbootdemo.dto.UserDto.User;

public interface UserAbstractDao {
    int getMatchCount(String userName,String password);
    User findByUserName(String userName);
    void updateLoginInfo(User user);
    void insertIntoUser(User user);
}

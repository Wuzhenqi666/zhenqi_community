package com.example.springboot.springbootdemo.service;

import com.example.springboot.springbootdemo.dao.UserDao.UserAbstractDao;
import com.example.springboot.springbootdemo.dto.UserDto.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private  User user;
    @Autowired
    private UserAbstractDao userAbstractDao;
    @Override
    public void loginSuccess(String userName, String userPassword) {

    }

    @Override
    public User findUserByUserName(String userName) {
        return null;
    }

    @Override
    public void updateUserInf(User user) {

    }

    @Override
    public void registeSucess() {
        User user = this.user;
        userAbstractDao.insertIntoUser(user);


    }
}

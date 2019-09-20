package com.example.springboot.springbootdemo.dao.UserDao;

import com.example.springboot.springbootdemo.dto.UserDto.User;

public class UserDaoImpl implements UserAbstractDao {
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
}

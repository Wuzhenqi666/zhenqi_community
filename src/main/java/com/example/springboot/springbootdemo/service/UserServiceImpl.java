package com.example.springboot.springbootdemo.service;

import com.example.springboot.springbootdemo.dto.UserDto.User;
import com.example.springboot.springbootdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean registeUser(User user) {
        userMapper.insertIntoUser(user);
        return true;
    }
}

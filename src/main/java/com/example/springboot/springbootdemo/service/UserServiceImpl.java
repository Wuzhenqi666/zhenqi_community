package com.example.springboot.springbootdemo.service;

import com.example.springboot.springbootdemo.dto.UserDto.User;
import com.example.springboot.springbootdemo.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public boolean registeUser(User user) {
        try{
            user.setLastVisit(new Date());
            user.setCredits(0);
            userMapper.insertIntoUser(user);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }

    @Override
    @Transactional
    public boolean loginSuccess(User user) {
        try {
            user.setLastVisit(new Date());
            user.setCredits(user.getCredits()+ 10);
            userMapper.updateUserLoginInf(user);
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean loginService(User user) {
        if (userMapper.findUserByUsername(user.getUserName()).size()<=0){
            return false;
        }else{
            System.out.println(userMapper.findUserByUsername(user.getUserName()));
            return true;
        }
    }
}

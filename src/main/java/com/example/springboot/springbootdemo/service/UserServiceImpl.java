package com.example.springboot.springbootdemo.service;

import com.example.springboot.springbootdemo.dto.UserDto.User;
import com.example.springboot.springbootdemo.mapper.UserMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private User user;

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
    public User loginSuccess(User user) {
        try {
            user.setLastVisit(new Date());
            user.setCredits(user.getCredits()+ 10);
            userMapper.updateUserLoginInf(user);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
        return user;
    }

    @Override
    public User loginService(User user) {

        if (userMapper.findUserByUsername(user.getUserName()).size()>0){
            this.user = userMapper.findUserByUsername(user.getUserName()).get(0);
            if(this.user.getUserPassword().equals(user.getUserPassword())){
                logger.info("登陆成功"+this.user);
                return this.user;
            }else {
                return null;
            }
        }else{
            return null;
        }
    }
}

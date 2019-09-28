package com.example.springboot.springbootdemo.mapper;

import com.example.springboot.springbootdemo.dto.UserDto.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> selectAllUser();
    boolean insertIntoUser(User user);
}

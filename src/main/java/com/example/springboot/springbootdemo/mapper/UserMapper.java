package com.example.springboot.springbootdemo.mapper;

import com.example.springboot.springbootdemo.dto.UserDto.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper{

    List<User> selectAllUser();
    boolean insertIntoUser(User user);
    List<User> findUserByUsername(String userName);
    boolean updateUserLoginInf(User user);

}

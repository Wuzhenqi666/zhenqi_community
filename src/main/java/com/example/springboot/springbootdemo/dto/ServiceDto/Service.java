package com.example.springboot.springbootdemo.dto.ServiceDto;

import com.example.springboot.springbootdemo.dto.UserDto.User;

import java.io.Serializable;
import java.util.Date;

public class Service implements Serializable {
    private String userName;
    private Date lastVisit;

}
package com.example.springboot.springbootdemo.dto.ServiceDto;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Service {
    private String userName;
    private Date lastVisit;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }
}

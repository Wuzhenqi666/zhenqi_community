package com.example.springboot.springbootdemo.model.token;

import org.springframework.stereotype.Component;

/**
 * @author JemLeeo
 * @date 2019/10/8 10:19
 */
@Component
public class TokenModel {
    private Long userId;
    private String token;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

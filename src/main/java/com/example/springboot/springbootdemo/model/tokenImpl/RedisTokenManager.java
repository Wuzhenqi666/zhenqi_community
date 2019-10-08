package com.example.springboot.springbootdemo.model.tokenImpl;

import com.example.springboot.springbootdemo.model.token.TokenModel;
import com.example.springboot.springbootdemo.model.tokenInterface.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import java.util.UUID;



/**
 * @author JemLeeo
 * @date 2019/10/8 10:27
 */
@Component
public class RedisTokenManager implements TokenManager {

    private RedisTemplate redisTemplate;

    @Autowired
    private TokenModel tokenModel;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public TokenModel createToken(Long userId) {
        String token = UUID.randomUUID().toString().replace("-","");
        tokenModel.setToken(token);
        tokenModel.setUserId(userId);
        redisTemplate.boundValueOps(userId).set(token);
        return tokenModel;
    }

    @Override
    public boolean checkToken(TokenModel model) {
        if (model == null){
            return false;
        }
        String token = (String) redisTemplate.boundValueOps(model.getToken()).get();
        System.out.println(token);
        if (token == null || !token.equals (tokenModel.getToken ())) {
            return false;
        }

        return true;
    }

    @Override
    public TokenModel getToken(String authentication) {
        if(tokenModel==null ||  authentication.length()==0){
            return null;
        }
        String [] param = authentication.split ("_");
        if (param.length != 2) {
            return null;
        }
        // 使用 userId 和源 token 简单拼接成的 token，可以增加加密措施
        Long userId = Long.parseLong(param [0]);
        String token = param [1];
        tokenModel.setUserId(userId);
        tokenModel.setToken(token);
        return tokenModel;
    }

    @Override
    public void deleteToken(Long userId) {
        redisTemplate.delete(userId);
    }

    }




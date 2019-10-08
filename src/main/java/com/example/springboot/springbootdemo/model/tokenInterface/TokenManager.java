package com.example.springboot.springbootdemo.model.tokenInterface;

import com.example.springboot.springbootdemo.model.token.TokenModel;

/**
 * @author JemLeeo
 * @date 2019/10/8 10:22
 */
public interface TokenManager {
    public TokenModel createToken(Long userId);
    public boolean checkToken(TokenModel tokenModel);
    public TokenModel getToken(String authentication);
    public void deleteToken(Long userId);
}

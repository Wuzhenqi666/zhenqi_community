package com.example.springboot.springbootdemo.interceptor.loginInterceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.mysql.cj.conf.PropertyKey.logger;

/**
 * @author JemLeeo
 * @date 2019/10/9 10:40
 */
public class LoginInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandler"+request.getHeader("token"));
        return true;
    }
}

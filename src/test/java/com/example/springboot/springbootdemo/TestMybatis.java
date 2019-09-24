package com.example.springboot.springbootdemo;

import java.io.IOException;

public class TestMybatis {
    public static void main(String[] args) throws IOException
    {
        MybatisFirst mybatis = new MybatisFirst();;
        mybatis.selectAllUserId();
    }

}

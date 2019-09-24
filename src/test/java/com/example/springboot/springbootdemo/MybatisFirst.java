package com.example.springboot.springbootdemo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MybatisFirst {
    //保存数据库中已有的主键。
    private static List<Integer> allUserId = new ArrayList<Integer>();
    private static final String resource = "SqlMapConfig.xml";
    private SqlSessionFactory sqlSessionFactory;

    MybatisFirst() throws IOException
    {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    //选取所有的主键
    public void selectAllUserId()
    {
        SqlSession session = sqlSessionFactory.openSession();
        try{
            allUserId = session.selectList("org.mybatis.selectAllUserId");
            System.out.println("所有的ID为：");
            for(Integer integer : allUserId)
            {
                System.out.println(integer);
            }
        } finally {
            session.close();
        }
    }



}

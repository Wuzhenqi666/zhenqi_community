package com.example.springboot.springbootdemo.dao.UserDao;

import com.example.springboot.springbootdemo.dto.UserDto.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class UserDaoImpl implements UserAbstractDao {

    private static final String resource = "SqlMapConfig.xml";
    private SqlSessionFactory sqlSessionFactory;
    UserDaoImpl() throws IOException
    {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Override
    public int getMatchCount(String userName, String password) {
        return 0;
    }

    @Override
    public User findByUserName(String userName) {
        return null;
    }

    @Override
    public void updateLoginInfo(User user) {

    }

    @Override
    public void insertIntoUser(User user) {
        SqlSession session = sqlSessionFactory.openSession();
        session.selectOne("org.mybatis.insertIntoUser", user);
    }
}

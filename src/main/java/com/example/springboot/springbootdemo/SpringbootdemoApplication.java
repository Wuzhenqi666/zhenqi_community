package com.example.springboot.springbootdemo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;


@SpringBootApplication(scanBasePackages = {"com.example.springboot.springbootdemo"})
@EntityScan(basePackages ="com.example.springboot.springbootdemo.dto")
@MapperScan(value = "com.example.springboot.springbootdemo.mapper",sqlSessionFactoryRef ="sqlSessionFactory",sqlSessionTemplateRef = "sqlSessionTemplate",annotationClass = Repository.class)
public class SpringbootdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootdemoApplication.class, args);
    }

}

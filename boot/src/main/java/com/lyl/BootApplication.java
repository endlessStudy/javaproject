package com.lyl;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by liuyl on 2018/3/14.
 */
@SpringBootApplication
@MapperScan(value = "com.lyl.mapper")
public class BootApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class,args);
    }
}

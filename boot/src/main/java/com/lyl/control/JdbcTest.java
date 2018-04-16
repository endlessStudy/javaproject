package com.lyl.control;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuyl on 2018/3/20.
 */
@RestController
@RequestMapping("/test")
public class JdbcTest {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @RequestMapping("/city")
    public Object getCity(){
        System.out.println("11111111");
        return jdbcTemplate.queryForList("select * from city");
        //jdbcTemplate.execute("select * from city");

    }
}
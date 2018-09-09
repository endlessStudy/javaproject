package com.lyl.control;

import com.lyl.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuyl on 2018/3/20.
 */
@RestController
public class MybatisTest {
    @Autowired
    CityMapper cityMapper;
    @RequestMapping("/mcity")
    public Object getCity(@PathVariable String string){
        return cityMapper.queryCity();
    }
}

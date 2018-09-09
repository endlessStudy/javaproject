package com.lyl.mapper;

import com.lyl.pojo.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by liuyl on 2018/3/20.
 */
@Mapper
public interface CityMapper {

    City queryCity();
}

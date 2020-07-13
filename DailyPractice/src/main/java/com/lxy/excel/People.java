package com.lxy.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import javax.annotation.Nonnull;
import java.io.Serializable;
import java.util.Date;

@Data
@ExcelTarget("people")
public class People implements Serializable {
    @Excel(name = "姓名", orderNum = "0")
    private String name;
    @Excel(name = "年龄", orderNum = "1")
    private int age;
    @Excel(name = "生日", orderNum = "2")
    private String birthday;
}
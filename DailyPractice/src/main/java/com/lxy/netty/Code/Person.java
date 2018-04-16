package com.lxy.netty.Code;

import java.io.Serializable;

/**
 * Created by liuyl on 2018/4/9.
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String sex;
    private int age;

    @Override
    public String toString() {
        return "name:" + name + " sex:" + sex + " age:" + age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

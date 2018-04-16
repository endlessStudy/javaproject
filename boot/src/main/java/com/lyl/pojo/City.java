package com.lyl.pojo;

import lombok.*;

import java.io.Serializable;

/**
 * Created by liuyl on 2018/3/20.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City implements Serializable{
    private String id;
    private String code;
    private String name;
    private String description;
}

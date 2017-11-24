package com.liuyl.util;

import java.util.UUID;

/**
 * Created by liuyl on 2017/8/24.
 */
public class UuidUtil {
    public static String getUuid(){
        String uuid = String.valueOf(UUID.randomUUID());
        return uuid.replace("-","");
    }
}

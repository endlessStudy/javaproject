package com.lxy.utils;

/**
 *
 */
public class CacheContans {

    /**key值的连接符*/
    public static final String CONTANCT = ".";

    /**读写权限：只读 */
    public static final int MODE_READ_ONLY = 1;

    /**读写权限：读写 */
    public static final int MODE_READ_AND_WRITE = 2;


    public static final String REGISTER_KEY = "register";

    public static final String CONFIG_NAME = "props.config";

    public static final String CONFIG_REGKEY = "redis.registerKeys";

    public static final String CONFIG_SERVER_NAME = "redis.serverName";

    /**redis服务器模式：单机版 */
    public static final int REDIS_PATTERN_SA = 1;

    /**redis服务器模式：集群版 */
    public static final int REDIS_PATTERN_CL = 2;
}

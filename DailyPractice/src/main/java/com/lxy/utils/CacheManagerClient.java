package com.lxy.utils;

/**
 * Created by liuyl on 2018/3/12.
 */
public class CacheManagerClient {
    // 默认redis模式为单机
    private static int type = CacheContans.REDIS_PATTERN_SA;
    /**
     * 设置redis的连接池
     * @param maxAcive redis连接池的最大连接数
     * @param maxIdle redis连接池最大能够保持idel状态的对象数
     * @param maxWait 当池内没有返回对象时，最大等待时间
     * @param port redis服务的端口号
     * @param testOnBorrow 当调用borrow Object方法时，是否进行有效性检查（true时不检查）
     * @param timeout 客户端连接过期时间
     * @param IP redis服务的IP地址
     * @param AUTH 密码
     */
    public static void initRedisPool(String IP, String port, String AUTH,
                                     String timeout, String maxAcive, String maxIdle, String maxWait,
                                     boolean testOnBorrow) {
        type = CacheContans.REDIS_PATTERN_SA;
        RedisPool.INSTANCE.setJedisPool(IP, port, AUTH, timeout, maxAcive, maxIdle, maxWait, testOnBorrow);
    }
}

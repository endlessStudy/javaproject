package com.liuyl.aop;

import com.liuyl.common.Global;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by liuyl on 2017/11/22.
 */
@Component
@Aspect
public class QueryAop {
    public Logger logger = LoggerFactory.getLogger(QueryAop.class);

    @Pointcut("execution(* com.liuyl.service.UserService.*(..))")
    public void pointcut() {
    }

    @Before(value = "pointcut()")
    protected void queryStart() {
        logger.info(System.currentTimeMillis() + "开始查询........");
    }

    @After(value = "pointcut()")
    protected void queryEnd() {
        logger.info(System.currentTimeMillis() + "查询结束........");
    }
}

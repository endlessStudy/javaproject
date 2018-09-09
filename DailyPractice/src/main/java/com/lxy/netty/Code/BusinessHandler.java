package com.lxy.netty.Code;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liuyl on 2018/4/9.
 */
public class BusinessHandler extends ChannelInboundHandlerAdapter{
    private Logger logger  = LoggerFactory.getLogger(BusinessHandler.class);
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Person person = (Person) msg;
        logger.info("BusinessHandler read msg from client :" + person.toString());
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }
}

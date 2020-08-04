package com.lxy.netty.first;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liuyl on 2018/1/15.
 */
@ChannelHandler.Sharable
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
	public Logger logger = LoggerFactory.getLogger(EchoClientHandler.class);

	@Override
	public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
		logger.info("Unregistered ： channel已被创建，但还未注册到EventLoop！" + "^_^ !");

	}

	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		logger.info("Registered : channel已被注册到了EventLoop" + "^_^ !");
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		super.channelReadComplete(ctx);
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.info("................channelActive()");
		ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!", CharsetUtil.UTF_8));
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		logger.info("连接失败！");
	}

	@Override
	protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf o) throws Exception {
		//o.capacity()
		byte[] byteArray = new byte[o.readableBytes()];
		o.readBytes(byteArray);
		String result = new String(byteArray, "UTF-8");
		System.out.println(result);
		logger.info("Client: " + new String(o.toString().getBytes(), "utf-8"));
		logger.info("Client received : " + ByteBufUtil.hexDump(o.readBytes(o.readableBytes())));
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}

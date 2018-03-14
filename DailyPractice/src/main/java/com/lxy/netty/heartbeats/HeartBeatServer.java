package com.lxy.netty.heartbeats;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import sun.security.tools.policytool.PolicyTool;

import java.util.concurrent.TimeUnit;

/**
 * Created by liuyl on 2018/2/5.
 */
public class HeartBeatServer {
    private final int port ;
    public HeartBeatServer(int port){
        this.port = port;
    }

    public void process() {
        EventLoopGroup eventLoopGroup1 = new NioEventLoopGroup(1);
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup(1);
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap().group(eventLoopGroup1,eventLoopGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline()
                            .addLast("ping",new IdleStateHandler(5,0,0, TimeUnit.SECONDS))
                            .addLast("decoder",new StringDecoder())
                            .addLast("encoder",new StringEncoder())
                            .addLast("heartBeat",new HearBeatServerHandler());
                    }
                });
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            System.out.println("server start listen at " + port);
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            try {
                eventLoopGroup.shutdownGracefully().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        HeartBeatServer heartBeatServer = new HeartBeatServer(9999);
        heartBeatServer.process();
    }

}

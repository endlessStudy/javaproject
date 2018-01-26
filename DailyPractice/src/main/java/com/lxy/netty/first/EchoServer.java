package com.lxy.netty.first;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.lang.reflect.Method;

/**
 * Created by liuyl on 2018/1/15.
 */
public class EchoServer {
    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void start() throws Exception {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            //服务启动程序
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(eventLoopGroup).
                channel(NioServerSocketChannel.class)
                .localAddress(port)
                .childHandler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel channel) throws Exception {
                        System.out.println("===========");
                        channel.pipeline().addLast(new EchoServerHandler());
                    }
                });
            ChannelFuture f = serverBootstrap.bind().sync();
            System.out.println(EchoServer.class.getName() + " started and listening for connections on " + f.channel().localAddress());
            f.channel().closeFuture().sync();
        } finally {
            eventLoopGroup.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws Exception {
        new EchoServer(7845).start();
    }
}

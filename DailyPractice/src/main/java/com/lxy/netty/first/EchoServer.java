package com.lxy.netty.first;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseDecoder;

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
                .childHandler(new ChannelInitializer<SocketChannel>() {//scoketChannel
                    @Override
                    protected void initChannel(SocketChannel channel) throws Exception {
                        System.out.println("===========" + channel);
                        channel.pipeline()
                            .addLast(new EchoServerHandler())
                            .addLast(new HttpRequestDecoder())
                            .addLast(new HttpResponseDecoder())
                            .addLast(new HttpObjectAggregator(512 * 1024))
                        ;
                    }
                }).option(ChannelOption.SO_BACKLOG, 128) // determining the number of connections queued
                .childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE);

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

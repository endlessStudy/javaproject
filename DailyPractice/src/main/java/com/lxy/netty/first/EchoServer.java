package com.lxy.netty.first;

import com.sun.deploy.util.ArrayUtil;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 *
 *
 *
 *
 *                   ________________________                                 __________________________
 *                  |                        |                               |                          |
 *                  |   <-----Inbound-----   |                               |   ---inbound------- >    |   ________
 *                  |   _____        ______  |                               |    _______      ____     |  |        |
 *      _______     |  |     |       |    |  |                               |    |     |     |    |    |  |        |
 *     |       |    |  |  ②  |       |  ③ | |     ___________________       |    |  ⑤  |     | ⑥ |    |  |        |
 *     |       |    |  |_____|       |____|  |     |                   |     |    |_____|     |____|    |  |        |
 *     |client |----|-------______-----------|-----|      network      |-----|--------------------------|--| server |
 *     |       |    |       |     |          |     |___________________|     |          ______          |  |        |
 *     |       |    |       |  ①  |          |                               |          |     |         |  |        |
 *     |       |    |       |_____|          |                               |          |  ④  |         |  |________|
 *     |       |    |                        |                               |          |_____|         |
 *     |_______|    |   -----Outbound--->    |                               |    <-----outbound----    |
 *                  |___ChannelPipeline______|                               |______ChannelPipeline_____|
 *
 *  ①：StringEncoder继承于MessageToMessageEncoder，而MessageToMessageEncoder又继承于ChannelOutboundHandlerAdapter
 *  ②：HelloWorldClientHandler.java
 *  ③：StringDecoder继承于MessageToMessageDecoder，而MessageToMessageDecoder又继承于ChannelInboundHandlerAdapter
 *  ④：StringEncoder 编码器
 *  ⑤：StringDecoder 解码器
 *  ⑥：HelloWorldServerHandler.java
 *
 *
 *
 */
public class EchoServer {
    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void start() throws Exception {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        EventLoopGroup workEventLoopGroup = new NioEventLoopGroup();

        try {
            //服务启动程序
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(eventLoopGroup,workEventLoopGroup)
                .channel(NioServerSocketChannel.class)
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

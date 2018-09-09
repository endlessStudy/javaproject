package com.lxy.netty.Code;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by liuyl on 2018/4/9.
 */
public class Client {
    public void connect(String host,int port) {
        EventLoopGroup wrokGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(wrokGroup).channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new PersonEncoder()).addLast(new ClientInitHandler());
                    }
                });
            ChannelFuture channelFuture = bootstrap.connect(host,port).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            wrokGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.connect("127.0.0.1",8000);
    }
}

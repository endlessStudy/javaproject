package com.lxy.netty.Code;

import com.lxy.netty.Code.util.ByteBufToBytes;
import com.lxy.netty.Code.util.ByteObjConverter;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Created by liuyl on 2018/4/9.
 */
public class PersonDecoder extends ByteToMessageDecoder{
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        ByteBufToBytes read = new ByteBufToBytes();
        Object obj = ByteObjConverter.ByteToObject(read.read(in));
        out.add(obj);
    }
}

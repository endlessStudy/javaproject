package com.lxy.netty.Code;

import com.lxy.netty.Code.util.ByteObjConverter;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by liuyl on 2018/4/9.
 */
public class PersonEncoder extends MessageToByteEncoder<Person> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Person msg, ByteBuf out) throws Exception {
        byte[] datas = ByteObjConverter.ObjectToByte(msg);
        out.writeBytes(datas);
        ctx.flush();
    }
}

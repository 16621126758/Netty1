package com.mogu61.Netty.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class NettyClientHandler extends SimpleChannelInboundHandler<String> {


    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println(s);
    }
    public void channelActive(ChannelHandlerContext ctx){
        System.out.println("to server");
        String s = "你好,nerttyn";

        System.out.println(s);
ctx.writeAndFlush(s);



    }
}

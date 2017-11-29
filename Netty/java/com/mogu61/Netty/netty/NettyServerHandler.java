package com.mogu61.Netty.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import redis.clients.jedis.Jedis;

public class NettyServerHandler extends SimpleChannelInboundHandler<String>{
    Jedis j = new Jedis();
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {

        System.out.println("shoudao");
       // System.out.println(s);
        j.publish("mew",s);
        ctx.writeAndFlush("谢谢，我很好，你呢?");
    }
}

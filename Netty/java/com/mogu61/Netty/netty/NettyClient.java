package com.mogu61.Netty.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class NettyClient {
    private final String host;
    private final int port;
    public NettyClient(String host,int port) throws Exception {
        this.port = port;
        this.host = host;
       start();
    }
    public void start()throws  Exception{
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();
                            p.addLast(new StringDecoder());
                            p.addLast(new StringEncoder());
                            p.addLast(new NettyClientHandler());
                        }
                    });
            ChannelFuture f = b.connect(host, port).sync();
            f.channel().close().sync();
        }finally{
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
       args =new  String[2];
       args[0] = "127.0.0.1";
       args[1] = "8183";
       if(args.length!=2){
           System.out.println("Usage:"+NettyClient.class.getSimpleName()+"<host> <port>");
           return;
       }
      final String host = args[0];
      final int port = Integer.parseInt(args[1]);
      new NettyClient(host,port).start();

    }


}

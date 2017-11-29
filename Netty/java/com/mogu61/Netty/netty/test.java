package com.mogu61.Netty.netty;

public class test {
    public static void main(String[] args) throws Exception {
        for (int i = 0;i<9;i++){
            NettyClient s = new NettyClient("127.0.0.1",8183);
        }
    }



}

package com.mogu61.Netty.netty;

import redis.clients.jedis.JedisPubSub;

public class RedisListener extends JedisPubSub{
    static int count = 1;
    public void onMessage(String channel,String message){
        System.out.println("channel:"+channel+"..receive"+message+count);
    }


}

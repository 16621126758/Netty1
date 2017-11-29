package com.mogu61.Netty.netty;

import redis.clients.jedis.Jedis;

public class dingyue
{
    public void dy(){
        RedisListener listener = new RedisListener();
        Jedis jedis = new Jedis("localhost");
        jedis.subscribe(listener,"mew");


    }
}

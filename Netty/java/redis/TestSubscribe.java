package redis;

import redis.clients.jedis.Jedis;

public class TestSubscribe {
    //订阅者
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        RedisMsgPubSubListener listener = new RedisMsgPubSubListener();
        jedis.subscribe(listener,"redisChat");
    }
}

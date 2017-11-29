package redis;

import redis.clients.jedis.Jedis;

public class TestPublish {
    public static void main(String[] args) throws Exception{
        Jedis jedis = new Jedis("localhost");
        jedis.publish("redisChat","Readis is a great");
        Thread.sleep(5000);
        jedis.publish("redisChat","builde your dream");
        Thread.sleep(5000);
        jedis.publish("redisChat","over");
    }
}

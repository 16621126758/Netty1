package redis;

import redis.clients.jedis.Jedis;

public class Testredis {
    private static Jedis jedis;
    public static void main(String[] args) {
        test t = new test();
        t.setup();
        t.testString();


    }
}

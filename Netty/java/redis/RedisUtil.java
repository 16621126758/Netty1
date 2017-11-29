package redis;

import org.omg.CORBA.TIMEOUT;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {
    private static String ADDR = "127.0.0.1";
    private static int PORT = 6379;
    private static String AUTH = "admin";
    private static int MAX_ACTIVE = 1024;
    private static int MAX_IDLE = 200;
    private static int MAX_WAIT = 1000;
    private static int Timeout = 1000;
    private static JedisPool jedisPool = null;
    private static Boolean TEST_ON_BORROW = true;

    //初始化连接池
    static {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(MAX_ACTIVE);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(config, ADDR, PORT, Timeout, AUTH);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取Jedis实例
    public synchronized static Jedis getJedis() {
        try {
            if (jedisPool != null) {
                Jedis resource = jedisPool.getResource();
                return resource;
            } else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }
    //释放jedis资源
    public static void returnResource(final Jedis jedis){
        if (jedis != null){
          jedisPool.returnResource(jedis);
        }

    }
}

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class redis {
    public static void main(String[] args) {
//       Jedis jedis = new Jedis("localhost");
//        System.out.println("链接成功");
//        jedis.lpush("site","Runnob");
//        jedis.lpush("site","GOGLE");
//        jedis.lpush("site","taobao");
//        List<String> list = jedis.lrange("site",0,2);
//        for (int i = 0;i<list.size();i++){
//            System.out.println("列表选项为"+list.get(i));
//        }
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");

        // 获取数据并输出
        Set<String> keys = jedis.keys("*");
        Iterator<String> it=keys.iterator() ;
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key);
        }
    }
}

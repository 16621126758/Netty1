package redis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class test {
   public static Jedis jedis  = new Jedis("localhost");
    public void setup(){
        jedis = new Jedis("localhost",6379);
        jedis.auth("admin");
    }
    //redis存储字符转
    public void  testString(){
        //添加数据
        jedis.set("name","zhz");
        System.out.println(jedis.get("name"));
        jedis.append("name","is my herat");
        System.out.println(jedis.get("name"));
        jedis.del("name");
        //设置多个键值对
        System.out.println(jedis.get("name"));
        jedis.mset("name","liuxing","age","22","qq","1234");
        jedis.incr("age");//进行加一操作
        System.out.println(jedis.get("name")+"-"+jedis.get("age")+"-"+jedis.get("qq"));

    }
    //redis操作map
    public void testmap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "xinxin");
        map.put("age", "22");
        map.put("qq", "12312");
        jedis.hmset("user", map);
        //取出user中的name，执行结果是一个范型的List
        //第一个参数是存入redis中的map对象的key，后面跟得是放入map中的对象key，后面的可以可以有多个
        List<String> rsmap = jedis.hmget("user", "name", "age", "qq");
        System.out.println(rsmap);
        //删除map中个的某个键值
        jedis.hdel("user", "age");
        System.out.println(jedis.hmget("user", "age"));
        System.out.println(jedis.hlen("user"));//返回key为user的键中存放的值的个数
        System.out.println(jedis.exists("user"));//是否存在键
        System.out.println(jedis.hkeys("user"));//返回map对象中的所有key
        System.out.println(jedis.hvals("user"));//返回map对象中所有的value
        Iterator<String> it = jedis.hkeys("user").iterator();
        while (it.hasNext()) {
            String key = it.next();
            System.out.println(key + ";" + jedis.hmget("user", key));
        }
    }
    public void testList(){   jedis.del("java framework");
        System.out.println(jedis.lrange("java framework",0,-1));

    }



    }


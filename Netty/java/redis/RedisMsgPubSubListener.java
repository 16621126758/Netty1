package redis;

import redis.clients.jedis.JedisPubSub;

public class RedisMsgPubSubListener extends JedisPubSub{
    public void onMessage(String channel,String message){
        System.out.println("channel:"+channel+"receives message:"+message);
        //this.unsubscribe();取消订阅
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println("channel"+channel+"is been unsubscribed:"+subscribedChannels);
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println("channel"+channel+"is been subscribed:"+subscribedChannels);
    }
}

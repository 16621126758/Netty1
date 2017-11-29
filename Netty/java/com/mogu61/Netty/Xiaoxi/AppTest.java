package com.mogu61.Netty.Xiaoxi;

public class AppTest {
    public static void main(String[] args) throws Exception {
        PushBlockQueue.getInstance().start();
        for(;;){
            Thread.sleep(1000);
            PushBlockQueue.getInstance().put("0123456");
        }
    }
}

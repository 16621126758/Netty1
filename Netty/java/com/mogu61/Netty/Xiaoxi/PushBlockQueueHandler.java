package com.mogu61.Netty.Xiaoxi;

public class PushBlockQueueHandler implements Runnable {
    private Object obj;
    public PushBlockQueueHandler(Object obj) {
        this.obj = obj;
    }
    public void run(){
        doBusiness();
    }
    public void doBusiness(){
        System.out.println("处理请求"+obj);
    }
}

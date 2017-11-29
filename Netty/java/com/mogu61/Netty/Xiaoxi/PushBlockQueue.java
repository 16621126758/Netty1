package com.mogu61.Netty.Xiaoxi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class PushBlockQueue extends LinkedBlockingQueue<Object> {
    //private static final long serialVersionUID = -8224792866430647454L;
    private static ExecutorService es = Executors.newFixedThreadPool(10);//线程池
    private static PushBlockQueue pbq = new PushBlockQueue();//单例
    private boolean flag = false;

    private PushBlockQueue(){}

    public static PushBlockQueue getInstance(){
        return pbq;
    }

    /**
     * 队列监听启动
     */
    public void start(){
        if(!this.flag){
            this.flag = true;
        }else{
            throw new IllegalArgumentException("队列已处于启动状态,不允许重复启动.");
        }
        new Thread(new Runnable(){

            public void run() {
                while(flag){
                    try {
                        Object obj = take();//使用阻塞模式获取队列消息
                        //将获取消息交由线程池处理
                        es.execute(new PushBlockQueueHandler(obj));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    /**
     * 停止队列监听
     */
    public void stop(){
        this.flag = false;
    }
}

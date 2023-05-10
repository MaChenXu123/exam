package com.example.exam.utils.threadUtils;


/*
本来想做如果用户有几分钟每点击这个接口 就把这个接口对应的数据从redis中清除缓存  但是现在先做设置redis过期时间
 */
public class ClearThread implements Runnable {
    // 用标志来判断是否暂停线程
    private volatile boolean running = true;
    //倒计时时间
    private int count;

    @Override
    public void run() {
        // 如果倒计时不是0或者标志不是false就继续执行
        while (count > 0 && running) {
            count--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                running = false;
            }
        }
    }

    //构造函数初始化时间
    public ClearThread(int count) {
        this.count = count;
    }

    //停止清楚
    public void stop() {
        running = false;
    }
}

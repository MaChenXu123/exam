package com.example.exam.temp;


import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class CountDown implements Runnable{
    private volatile boolean temp = true;
    private int limitSec;
    @Override
    public void run() {
        System.out.println("Count from " + limitSec);
            while (limitSec > 0 && temp) {
                limitSec--;
                System.out.println("remians " + limitSec + " s");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    temp=false;
                }
                System.out.println("实现了");
            }
        if (temp) {
            System.out.println("Time is out");
        }
    }

    public CountDown(int limitSec)  {
        this.limitSec = limitSec;
    }
    //Test
/*	public static void main(String[] args) throws InterruptedException {
        new CountDown(10);
    }*/
    public void stop() {
        temp = false;
    }
}
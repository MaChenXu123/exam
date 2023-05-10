package com.example.exam.temp;

public class CountdownThread implements Runnable {
    private volatile boolean running = true;
    private int count;

    public CountdownThread(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        while (count > 0 && running) {
            System.out.println(count);
            count--;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Countdown interrupted!");
                running = false;
            }
        }

        if (running) {
            System.out.println("Countdown finished!");
        }
    }

    public void stop() {
        running = false;
    }
}
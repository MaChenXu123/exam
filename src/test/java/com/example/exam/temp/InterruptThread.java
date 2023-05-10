package com.example.exam.temp;

public class InterruptThread implements Runnable {
    private Thread targetThread;

    public InterruptThread(Thread targetThread) {
        this.targetThread = targetThread;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Interrupting countdown thread...");
        targetThread.interrupt();
    }
}
package org.example;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": MyRunnable is running");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(threadName + ": MyRunnable has been executed");
    }
}

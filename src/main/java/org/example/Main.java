package org.example;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new MyThread();
        thread1.start();

        Thread thread2 = new Thread(new MyRunnable(), "Thread 2");
        thread2.start();

        Thread thread3 = new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + ": Lambda runnable is running");
            System.out.println(threadName + ": Lambda runnable has been executed");
        }, "Thread 3");
        thread3.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n\n");
        StoppableRunnable stoppableRunnable = new StoppableRunnable();
        Thread thread4 = new Thread(stoppableRunnable);

        thread4.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Requesting stop");
        stoppableRunnable.requestStop();
        System.out.println("Stop has been requested");

        Thread thread5 = new Thread(new MyRunnable(), "Thread 5");

        thread5.setDaemon(true);
        thread5.start();

        try {
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
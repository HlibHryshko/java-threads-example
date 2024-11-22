package org.example;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread is running");
        System.out.println("MyThread has been executed");
    }
}

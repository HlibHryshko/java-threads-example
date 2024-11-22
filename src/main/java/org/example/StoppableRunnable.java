package org.example;

public class StoppableRunnable implements Runnable{
    private boolean isStopRequested = false;

    public synchronized void requestStop() {
        isStopRequested = true;
    }

    public synchronized boolean isStopRequested() {
        return isStopRequested;
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("StoppableRunnable is running");
        while (!isStopRequested()) {
            sleep(1000);
            System.out.println("...");
        }
        System.out.println("StoppableRunnable is stopped");
    }
}

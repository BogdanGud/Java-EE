package javaee.hw3.concurrency.Semaphore;

import javaee.hw3.concurrency.SemaphoreInterface.*;


public class SemaphoreImpl implements Semaphore {
    private int threadsCounter;

    public SemaphoreImpl(int threadsCounter) {
        this.threadsCounter = threadsCounter;
    }

    public synchronized void acquire() throws InterruptedException {
        acquire(1);

    }

    public synchronized void acquire(int permits) throws InterruptedException {
        if (permits < 0) throw new IllegalArgumentException();
        if (threadsCounter > permits) {
            threadsCounter -= permits;
        } else {
            this.wait();
        }

    }

    public synchronized void release() {
        release(1);

    }

    public synchronized void release(int permits) {
        if (permits < 0) throw new IllegalArgumentException();
        while (permits > 0) {
            threadsCounter++;
            if (threadsCounter > 0) {
                this.notify();
            }
            permits--;
        }
    }


    public int getAvailablePermits() {
        return threadsCounter;
    }
}

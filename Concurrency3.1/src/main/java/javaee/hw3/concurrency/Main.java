package javaee.hw3.concurrency;

import javaee.hw3.concurrency.Semaphore.SemaphoreImpl;
import javaee.hw3.concurrency.SemaphoreInterface.Semaphore;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Runnable longAction = new Runnable() {

            final Random random = new Random();
            final Semaphore semaphore = new SemaphoreImpl(3);

            int threadCounter = 0;

            public void run() {
                int time = random.nextInt(7);
                int threadNumber = threadCounter++;
                try {
                    semaphore.acquire();

                    System.out.println("Do something long for " +
                            time + " seconds, thread №" + threadNumber);

                    Thread.sleep(time * 1000);

                    System.out.println("Done thread №" +
                            threadNumber + "!");

                    semaphore.release();
                } catch (InterruptedException intEx) {
                    intEx.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 12; i++)
            new Thread(longAction).start();
    }
}


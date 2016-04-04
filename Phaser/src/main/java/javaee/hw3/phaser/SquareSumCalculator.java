package javaee.hw3.phaser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class SquareSumCalculator implements SquareSum {
    public long getSquareSum(int[] values, int numberOfThreads) {
        final int startOffset = values.length / numberOfThreads;
        Phaser phaser = new Phaser(numberOfThreads);

        List<Callable<Long>> callables = new ArrayList<>();
        IntStream.range(0, numberOfThreads).forEach(i -> callables.add(() -> {
            phaser.register();
            long tempResult = 0;
            int startIndex = i * startOffset;
            int endIndex;
            if ((i + 1) == numberOfThreads) {
                endIndex = values.length;
            } else {
                endIndex = (i + 1) * startOffset;
            }
            for (int j = startIndex; j < endIndex; j++) {
                tempResult += Math.pow(values[i], 2);
            }
            phaser.arrive();
            phaser.arriveAndAwaitAdvance();
            //System.out.println("Thread: " + i + ", result = " + tempResult);
            return tempResult;

        }));

        Long result = 0L;
        ExecutorService executor = Executors.newCachedThreadPool();
        try {
            List<Future<Long>> sum = executor.invokeAll(callables);
            for (Future<Long> f : sum) {
                result = result + f.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
        return result;
    }

    public long getSquareSum(int[] values) {
        long result = 0;
        for (int i = 0; i < values.length; i++) {
            result += Math.pow(values[i], 2);
        }
        return result;
    }
}

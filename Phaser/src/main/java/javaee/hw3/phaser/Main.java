package javaee.hw3.phaser;


import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        final int numOfEllements = 100;
        final int numOfThreads = 10;
        int[] input = new int[numOfEllements];
        SquareSumCalculator calculator = new SquareSumCalculator();
        SquareSumCalculator calculator2 = new SquareSumCalculator();

        for (int i = 0; i < input.length; i++) {
            input[i] = 52;
        }
        System.out.println(Arrays.toString(input));
        System.out.println("Result of " + numOfThreads + " threads : "
                + calculator2.getSquareSum(input, numOfThreads));
        System.out.println();
        System.out.println("Result of a single thread : " + calculator.getSquareSum(input));
    }
}

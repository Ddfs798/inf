package org.example;


public class Integral {
    static double sum;
    static int numThreads = 4;
    static int n = 1000000;

    public static void main(String[] args) throws InterruptedException {
        double a = 0.0;
        double b = 1.0;
        double h = (b - a) / n;

        TrapezoidalTask[] tasks = new TrapezoidalTask[numThreads];
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            int start = i * n / numThreads;
            int end = (i + 1) * n / numThreads;
            tasks[i] = new TrapezoidalTask(start, end, h);
            threads[i] = new Thread(tasks[i]);
            threads[i].start();
        }

        for (int i = 0; i < numThreads; i++) {
            threads[i].join();
        }

        System.out.println("Интеграл x^2 * e^x от 0 до 1: " + sum);
    }
}

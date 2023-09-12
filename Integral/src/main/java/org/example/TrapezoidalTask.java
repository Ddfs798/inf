package org.example;

public class TrapezoidalTask implements Runnable {

    private int startIndex;
    private int endIndex;
    private double h;

    TrapezoidalTask(int startIndex, int endIndex, double h) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.h = h;
    }

    @Override
    public void run() {
        double partialSum = (f(startIndex * h) + f(endIndex * h))/2.0;
        for (int i = startIndex + 1; i < endIndex; i++) {
            partialSum += f(i * h);
        }
        partialSum *= h;

        synchronized (Integral.class) {
            Integral.sum += partialSum;
        }
    }

    private static double f(double x) {
        return x * x * Math.exp(x);
    }
}


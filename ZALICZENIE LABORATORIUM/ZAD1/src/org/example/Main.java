package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int numThreads = 10;
        int range = 100;

        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            int start = (i * range / numThreads) + 1;
            int end = ((i + 1) * range / numThreads);
            threads[i] = new Thread(new Worker(start, end));
            threads[i].start();
        }

        for (int i = 0; i < numThreads; i++) {
            threads[i].join();

        }
    }
}

class Worker implements Runnable {
    private int start;
    private int end;

    public Worker(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = start; i <= end; i++) {

            sum += i;

        }
        double avg = (double) sum / (end - start + 1);
        System.out.println("Suma od: " + start + " do: " + end + " to: " + sum + " a średnia to: " + avg);
    }
}
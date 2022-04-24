package com.juc.www.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        Task task = new Task();
        for (int i = 0; i < 4; i++){
            threadPool.submit(task);
        }

        System.out.println(task.integer);
        threadPool.shutdown();
    }

    public static class Task implements Runnable{

        public AtomicInteger integer = new AtomicInteger();

        @Override
        public void run() {
            integer.incrementAndGet();
        }
    }
}

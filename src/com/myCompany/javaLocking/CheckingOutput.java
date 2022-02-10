package com.myCompany.javaLocking;

/**
 * @author Tatek Ahmed on 2/8/2022
 */
public class CheckingOutput {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();

        MultiThreadingProcessor multiThreadingProcessor = new MultiThreadingProcessor();

        Thread t1 = new Thread(() -> {
            try {
                multiThreadingProcessor.producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                multiThreadingProcessor.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

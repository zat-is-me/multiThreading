package com.myCompany.javaLocking;

import java.util.Scanner;

/**
 * @author Tatek Ahmed on 2/10/2022
 **/

class WaitNotifyApp {
    public void produce() throws InterruptedException {
        synchronized (this){
            System.out.println("Producer thread running ....");
            wait();
            System.out.println("Thread resume ");
        }
    }

    public void consume() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);
        synchronized (this){
            System.out.println("waiting for enter key to be press");
            scanner.nextLine();
            notify();
            System.out.println("Please wait thread is sleeping for 20000 millisecond ");
            Thread.sleep(20000);
        }
    }
}
public class WaitAndNotify {
    public static void main(String[] args) throws InterruptedException {
        WaitNotifyApp app = new WaitNotifyApp();

        Thread t1 = new Thread(() -> {
            try {
                app.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                app.consume();
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
package com.myCompany.javaLocking;

import java.util.Scanner;

/**
 * @author Tatek Ahmed on 2/9/2022
 **/

class App extends Thread {
    private volatile boolean running = true;

    @Override
    public void run() {
        while (running){
            System.out.println(" press enter to stop ...... ");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutDown() {
        running = false;
    }
}

public class StoppingThreadByValueChange{
    public static void main(String[] args) throws InterruptedException {
        App app = new App();
        app.start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        app.shutDown();
    }
}
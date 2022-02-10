package com.myCompany.javaLocking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Tatek Ahmed on 2/9/2022
 **/

public class SemaphoreConcurrencyThread {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 200; i++) {
            executorService.submit(() -> Connection.getInstance().connect());
        }

        executorService.shutdown();
        executorService.awaitTermination(1,TimeUnit.DAYS);
    }
}
class Connection {
    private static Connection instance = new Connection();
    Semaphore semaphore = new Semaphore(10);
    private int connections = 0;

    private  Connection(){
    }
    public static Connection getInstance(){
        return instance;
    }
    public void connect()  {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try{
            doConnect();
        }finally {
            semaphore.release();
        }
    }

    public void doConnect(){
        synchronized (this){
            connections++;
            System.out.println("connected ... " + connections);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this){
            connections--;
        }
    }
}
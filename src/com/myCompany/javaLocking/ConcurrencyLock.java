package com.myCompany.javaLocking;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Tatek Ahmed on 2/8/2022
 */

public class ConcurrencyLock implements Runnable{

    private Resource resource;
    private Lock lock;

    public ConcurrencyLock(Resource r){
        this.resource = r;
        this.lock = new ReentrantLock();
    }

    @Override
    public void run() {
        System.out.println(new Date());
        try {
            if(lock.tryLock(10, TimeUnit.SECONDS)){
                System.out.println(Thread.currentThread().getName());
                resource.doSomething();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            //release lock
            lock.unlock();
        }
        resource.doLogging();
    }

}

